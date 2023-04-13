package elite.sas.core.workflows.definition;

public enum WorkflowStatus {
    STARTED("Started"),
    EXECUTING("Executing"),
    FAILED("Failed"),
    RETRYING("Retrying"),
    SUCCESSFUL("Successful"),
    COMPLETED_WITH_ERROR("Workflow completed with but some activit(y/ies) have returned empty data");


    WorkflowStatus(String label) {
        this.label = label;
    }

    private final String label;

    public String getLabel() {
        return label;
    }
}
