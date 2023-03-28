package elite.sas.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter @Getter
public class Application extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "applicant")
    private AppUser applicant;

    @ManyToOne
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(15) DEFAULT 'PENDING'")
    private ApplicationStatus applicationStatus;

    @Column
    private String application;

    @Column
    private String schoolLetterUrl;
    @Column
    private String cvUrl;

    public Application() {}

    @Builder
    public Application(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, AppUser applicant, Listing listing, ApplicationStatus applicationStatus, String application, String schoolLetterUrl, String cvUrl) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.applicant = applicant;
        this.listing = listing;
        this.applicationStatus = applicationStatus;
        this.application = application;
        this.schoolLetterUrl = schoolLetterUrl;
        this.cvUrl = cvUrl;
    }

}
