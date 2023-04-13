package elite.sas.core.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Entity
@Getter @Setter
public class AttachmentWeek extends BaseModel{

    @Column(nullable = false)
    private int weekNumber;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Log> logs;

    private String weekSummary;
    private String studentComment;
    private String industrySupervisorComment;
    private String schoolSupervisorComment;

    private boolean isActive = true;


    public AttachmentWeek() {
    }

    @Builder
    public AttachmentWeek(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int weekNumber, List<Log> logs, String weekSummary, String studentComment, String industrySupervisorComment, String schoolSupervisorComment, boolean isActive) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.weekNumber = weekNumber;
        this.logs = logs;
        this.weekSummary = weekSummary;
        this.studentComment = studentComment;
        this.industrySupervisorComment = industrySupervisorComment;
        this.schoolSupervisorComment = schoolSupervisorComment;
        this.isActive = isActive;
    }

    public Optional<Log> todayLog() {
        var currentDate = LocalDateTime.now();
        return logs.stream().filter(l -> l.getCreatedAt().toLocalDate().isEqual(currentDate.toLocalDate()))
                .findFirst();
    }
    public Optional<Log> previousDayLog() {
        var currentDate = LocalDateTime.now().minusDays(1);
        return logs.stream().filter(l -> l.getCreatedAt().toLocalDate().isEqual(currentDate.toLocalDate()))
                .findFirst();
    }
}
