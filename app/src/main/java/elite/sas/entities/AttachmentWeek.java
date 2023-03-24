package elite.sas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


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


    public AttachmentWeek() {
    }
}
