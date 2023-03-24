package elite.sas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter @Getter
public class Attachment extends BaseModel{
    @ManyToOne
    private Student student;
    @ManyToOne
    @JoinColumn(name = "company")
    private Tenant tenant;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AttachmentPeriod attachmentPeriod;
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;
    /**
     * attachment end date, defaults to 3 months from current time
     */
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate = LocalDateTime.now().plusMonths(3);
    @ManyToOne
    @JoinColumn(name = "industry_supervisor")
    private User industrySupervisor;
    @ManyToOne
    @JoinColumn(name = "school_supervisor")
    private User schoolSupervisor;

    public Attachment() {}

    public Attachment(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Student student, Tenant tenant, AttachmentPeriod attachmentPeriod, LocalDateTime startDate, LocalDateTime endDate, User industrySupervisor, User schoolSupervisor) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.student = student;
        this.tenant = tenant;
        this.attachmentPeriod = attachmentPeriod;
        this.startDate = startDate;
        this.endDate = endDate;
        this.industrySupervisor = industrySupervisor;
        this.schoolSupervisor = schoolSupervisor;
    }
}
