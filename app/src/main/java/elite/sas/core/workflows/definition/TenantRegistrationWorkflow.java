package elite.sas.core.workflows.definition;

import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.entities.Tenant;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface TenantRegistrationWorkflow extends BaseWorkflow{
    @WorkflowMethod
    Tenant handle(CreateTenantParams params);
}
