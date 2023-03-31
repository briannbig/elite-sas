package elite.sas.workflows.definition;

import elite.sas.entities.Attachment;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.util.List;

@WorkflowInterface
public interface ProcessDailyLogBookWorkflow extends BaseWorkflow {

    @WorkflowMethod
    String handle(List<Attachment> activeAttachments);

}
