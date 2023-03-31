package elite.sas.entities;

import elite.sas.util.TimeUtil;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
public class Attachment extends BaseModel {
    @ManyToOne
    private Student student;
    @ManyToOne
    @JoinColumn(name = "company")
    private Tenant tenant;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AttachmentPeriod attachmentPeriod;
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime startDate = TimeUtil.getNextMonday();
    /**
     * attachment end date, defaults to 3 months from current time
     */
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate = startDate.plusMonths(3);
    @ManyToOne
    @JoinColumn(name = "industry_supervisor")
    private AppUser industrySupervisor;
    @ManyToOne
    @JoinColumn(name = "school_supervisor")
    private AppUser schoolSupervisor;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<AttachmentWeek> attachmentWeeks;

    public Attachment() {
    }

    @Builder
    public Attachment(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Student student, Tenant tenant, AttachmentPeriod attachmentPeriod, LocalDateTime startDate, LocalDateTime endDate, AppUser industrySupervisor, AppUser schoolSupervisor, List<AttachmentWeek> attachmentWeeks) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.student = student;
        this.tenant = tenant;
        this.attachmentPeriod = attachmentPeriod;
        this.startDate = startDate;
        this.endDate = endDate;
        this.industrySupervisor = industrySupervisor;
        this.schoolSupervisor = schoolSupervisor;
        this.attachmentWeeks = attachmentWeeks;
    }


    public boolean isActive() {
        var now = LocalDateTime.now();
        return startDate.isBefore(now) && endDate.isAfter(now);
    }

    public static LocalDateTime getNextMonday() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextMonday = now.with(DayOfWeek.MONDAY);
        if (nextMonday.isBefore(now)) {
            nextMonday = nextMonday.plusWeeks(1);
        }
        return nextMonday;
    }
}
