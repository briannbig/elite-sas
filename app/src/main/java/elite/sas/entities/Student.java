package elite.sas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter @Getter
public class Student extends BaseModel{

    @OneToOne
    private AppUser appUser;

    @Column(unique = true, nullable = false)
    private String admissionNumber;

    @ManyToOne
    private Course course;

    public Student() {}

    @Builder()
    public Student(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, AppUser appUser, String admissionNumber, Course course) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.appUser = appUser;
        this.admissionNumber = admissionNumber;
        this.course = course;
    }
}
