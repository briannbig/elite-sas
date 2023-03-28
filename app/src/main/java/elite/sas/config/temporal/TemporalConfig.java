package elite.sas.config.temporal;

import elite.sas.activities.NotificationsActivityImpl;
import elite.sas.activities.RegistrationActivityImpl;
import elite.sas.activities.definition.NotificationsActivity;
import elite.sas.activities.definition.RegistrationActivity;
import elite.sas.workflows.TenantRegistrationWorkflowImpl;
import elite.sas.workflows.UserAccountRegistrationWorkflowImpl;
import elite.sas.workflows.definition.TenantRegistrationWorkflow;
import elite.sas.workflows.definition.UserAccountRegistrationWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.common.RetryOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import io.temporal.workflow.Workflow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class TemporalConfig {

    @Autowired
    private final RegistrationActivityImpl registrationActivity;
    @Autowired
    private final NotificationsActivityImpl notificationsActivity;



    @Bean
    public RetryOptions defaultRetryOptions() {
        return RetryOptions.newBuilder()
                .setInitialInterval(Duration.ofSeconds(1))
                .setMaximumInterval(Duration.ofSeconds(300))
                .setBackoffCoefficient(2)
                .setMaximumAttempts(50)
                .build();
    }

    @Bean
    public ActivityOptions defaultActivityOptions() {
        return ActivityOptions.newBuilder()
                .setStartToCloseTimeout(Duration.ofSeconds(300))
                .setRetryOptions(defaultRetryOptions())
                .setHeartbeatTimeout(Duration.ofSeconds(5))
                .build();
    }

    @Bean
    public WorkflowOptions workflowOptions() {
        return WorkflowOptions.newBuilder()
                .setRetryOptions(defaultRetryOptions())
                .setTaskQueue("SAS_TASK_QUEUE")
                .build();
    }

    @Bean
    WorkflowClient workflowClient() {
        WorkflowServiceStubs workflowServiceStubs = WorkflowServiceStubs.newLocalServiceStubs();
        return WorkflowClient.newInstance(workflowServiceStubs);
    }

    @Bean
    public WorkerFactory defaultWorkerFactory() {
        WorkerFactory workerFactory = WorkerFactory.newInstance(workflowClient());
        Worker worker = workerFactory.newWorker("SAS_TASK_QUEUE");
        worker.registerWorkflowImplementationTypes(UserAccountRegistrationWorkflowImpl.class, TenantRegistrationWorkflowImpl.class);
        worker.registerActivitiesImplementations(registrationActivity, notificationsActivity);

        return workerFactory;
    }

    public RegistrationActivity registrationActivity() {
        return Workflow.newActivityStub(RegistrationActivity.class, defaultActivityOptions());
    }

    public NotificationsActivity notificationsActivity() {
        return Workflow.newActivityStub(NotificationsActivity.class, defaultActivityOptions());
    }


    public TenantRegistrationWorkflow tenantRegistrationWorkflow() {
        return workflowClient().newWorkflowStub(TenantRegistrationWorkflow.class, workflowOptions());
    }
    public UserAccountRegistrationWorkflow userAccountRegistrationWorkflow() {
        return workflowClient().newWorkflowStub(UserAccountRegistrationWorkflow.class, workflowOptions());
    }




}
