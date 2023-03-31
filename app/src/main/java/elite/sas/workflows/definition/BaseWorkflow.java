package elite.sas.workflows.definition;

import io.temporal.workflow.QueryMethod;


public interface BaseWorkflow {

    @QueryMethod
    WorkflowStatus getStatus();


}
