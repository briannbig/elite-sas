package elite.sas.config.temporal;

import elite.sas.activities.NotificationsActivityImpl;
import elite.sas.activities.RegistrationActivityImpl;
import elite.sas.repository.TenantRepository;
import elite.sas.service.AppUserService;
import elite.sas.workflows.TenantRegistrationWorkflowImpl;
import elite.sas.workflows.UserAccountRegistrationWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class TemporalConfig {
    @Autowired
    private final AppUserService appUserService;
    @Autowired
    private final TenantRepository tenantRepository;


    @Bean
    WorkflowClient workflowClient() {
        WorkflowServiceStubs workflowServiceStubs = WorkflowServiceStubs.newLocalServiceStubs();
        return WorkflowClient.newInstance(workflowServiceStubs);
    }

    @Bean
    public WorkerFactory defaultWorkerFactory() {
        WorkerFactory workerFactory = WorkerFactory.newInstance(workflowClient());
        Worker worker = workerFactory.newWorker("SAS_TASK_QUEUE");

        var registrationActivity = new RegistrationActivityImpl(appUserService, tenantRepository);
        var notificationsActivity = new NotificationsActivityImpl();

        worker.registerWorkflowImplementationTypes(UserAccountRegistrationWorkflowImpl.class, TenantRegistrationWorkflowImpl.class);
        worker.registerActivitiesImplementations(registrationActivity, notificationsActivity);

        return workerFactory;
    }




}
