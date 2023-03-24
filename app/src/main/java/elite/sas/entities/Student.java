package elite.sas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter @Getter
public class Student extends User{
    @ManyToOne
    private Course course;

    public Student() {}

    @Builder(builderMethodName = "StudentBuilder")
    public Student(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Tenant tenant, String email, String userName, String firstName, String lastName, UserType userType, Course course) {
        super(Id, createdAt, updatedAt, deletedAt, tenant, email, userName, firstName, lastName, userType);
        this.course = course;
    }
}
