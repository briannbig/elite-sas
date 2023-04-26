package elite.sas.core.workflows.definition;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface ProcessWeeklyLogsWorkflow  extends BaseWorkflow{

    @WorkflowMethod
    String handle();
}
