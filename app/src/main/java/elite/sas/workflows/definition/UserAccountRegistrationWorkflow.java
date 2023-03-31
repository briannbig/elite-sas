package elite.sas.workflows.definition;

import elite.sas.api.params.CreateUserParams;
import elite.sas.entities.AppUser;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface UserAccountRegistrationWorkflow extends BaseWorkflow{
    @WorkflowMethod
    AppUser handle(CreateUserParams params);
}
