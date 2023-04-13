package elite.sas.core.workflows.definition;

import elite.sas.core.api.params.CreateStudentParams;
import elite.sas.core.entities.Student;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.util.Optional;

@WorkflowInterface
public interface RegisterStudentWorkflow extends BaseWorkflow{
    @WorkflowMethod
    Optional<Student> handle(CreateStudentParams params);
}
