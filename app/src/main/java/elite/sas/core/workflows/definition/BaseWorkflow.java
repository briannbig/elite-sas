package elite.sas.core.workflows.definition;

import io.temporal.workflow.QueryMethod;


public interface BaseWorkflow {

    @QueryMethod
    WorkflowStatus getStatus();


}
