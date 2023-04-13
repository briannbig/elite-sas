package elite.sas.core.entities;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
public class Listing extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "company")
    private Tenant tenant;

    @ManyToOne
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(7) DEFAULT 'APR_JUN'")
    private AttachmentPeriod attachmentPeriod;

    private String description;

    /**
     * application deadline, defaults to 3 weeks from current time
     */
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime deadline = LocalDateTime.now().plusWeeks(3);


    public Listing() {}

    @Builder
    public Listing(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Tenant tenant, Course course, AttachmentPeriod attachmentPeriod, String description, LocalDateTime deadline) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.tenant = tenant;
        this.course = course;
        this.attachmentPeriod = attachmentPeriod;
        this.description = description;
        this.deadline = deadline;
    }
}
