package elite.sas.core.util;

import elite.sas.core.activities.definition.LogBookActivity;
import elite.sas.core.activities.definition.NotificationsActivity;
import elite.sas.core.activities.definition.RegistrationActivity;
import elite.sas.core.workflows.definition.*;
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

    public static ProcessDailyLogBookWorkflow processDailyLogBookWorkflow() {
        return workflowClient().newWorkflowStub(ProcessDailyLogBookWorkflow.class, workflowOptions());
    }

    public static ProcessWeeklyLogsWorkflow processWeeklyLogsWorkflow() {
        return workflowClient().newWorkflowStub(ProcessWeeklyLogsWorkflow.class, workflowOptions());
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

    public static LogBookActivity logBookActivityStub() {
        return Workflow.newActivityStub(
                LogBookActivity.class,
                defaultActivityOptions());
    }
}
