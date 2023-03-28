package elite.sas.workflows.definition;

import elite.sas.api.params.CreateTenantParams;
import elite.sas.entities.Tenant;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface TenantRegistrationWorkflow{
    @WorkflowMethod
    Tenant handle(CreateTenantParams params);
}
