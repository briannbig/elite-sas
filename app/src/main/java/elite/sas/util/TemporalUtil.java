package elite.sas.util;

import elite.sas.activities.definition.NotificationsActivity;
import elite.sas.activities.definition.RegistrationActivity;
import elite.sas.workflows.definition.RegisterStudentWorkflow;
import elite.sas.workflows.definition.TenantRegistrationWorkflow;
import elite.sas.workflows.definition.UserAccountRegistrationWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.common.RetryOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public final class TemporalUtil {

    public static RetryOptions defaultRetryOptions() {
        return RetryOptions.newBuilder()
                .setInitialInterval(Duration.ofSeconds(1))
                .setMaximumInterval(Duration.ofSeconds(300))
                .setBackoffCoefficient(2)
                .setMaximumAttempts(50)
                .build();
    }

    public static ActivityOptions defaultActivityOptions() {
        return ActivityOptions.newBuilder()
                .setStartToCloseTimeout(Duration.ofSeconds(300))
                .setRetryOptions(defaultRetryOptions())
                .setHeartbeatTimeout(Duration.ofSeconds(5))
                .build();
    }

    public static WorkflowOptions workflowOptions() {
        return WorkflowOptions.newBuilder()
                .setRetryOptions(defaultRetryOptions())
                .setTaskQueue("SAS_TASK_QUEUE")
                .build();
    }

    static WorkflowClient workflowClient() {
        WorkflowServiceStubs workflowServiceStubs = WorkflowServiceStubs.newLocalServiceStubs();
        return WorkflowClient.newInstance(workflowServiceStubs);
    }

    public static TenantRegistrationWorkflow tenantRegistrationWorkflow() {
        return workflowClient().newWorkflowStub(TenantRegistrationWorkflow.class, workflowOptions());
    }

    public static UserAccountRegistrationWorkflow userAccountRegistrationWorkflow() {
        return workflowClient().newWorkflowStub(UserAccountRegistrationWorkflow.class, workflowOptions());
    }

    public static RegisterStudentWorkflow studentCreationWorkflow() {
        return workflowClient().newWorkflowStub(RegisterStudentWorkflow.class, workflowOptions());
    }

    public static RegistrationActivity registrationActivitiesStub() {
        return Workflow.newActivityStub(
                RegistrationActivity.class,
                defaultActivityOptions());
    }

    public static NotificationsActivity notificationsActivityStub() {
        return Workflow.newActivityStub(
                NotificationsActivity.class,
                defaultActivityOptions());
    }
}
