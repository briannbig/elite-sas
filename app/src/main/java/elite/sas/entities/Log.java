package elite.sas.entities;

import elite.sas.util.TimeUtil;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.UUID;

@Entity
@Getter @Setter
public class Log extends BaseModel{

    private String workDone;
    private String industrySupervisorComment;
    private String schoolSupervisorComment;


    public Log() {}

    @Builder
    public Log(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String workDone, String industrySupervisorComment, String schoolSupervisorComment) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.workDone = workDone;
        this.industrySupervisorComment = industrySupervisorComment;
        this.schoolSupervisorComment = schoolSupervisorComment;
    }


    @Override
    public String toString() {
        return "log ---- id: " + getId() + " --time--: " + TimeUtil.toString(getCreatedAt().getLong(ChronoField.INSTANT_SECONDS)) + " work done: " +  workDone;
    }
}
