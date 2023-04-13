package elite.sas.core.workflows.definition;

import elite.sas.core.api.params.CreateUserParams;
import elite.sas.core.entities.AppUser;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface UserAccountRegistrationWorkflow extends BaseWorkflow{
    @WorkflowMethod
    AppUser handle(CreateUserParams params);
}
