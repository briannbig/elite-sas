package elite.sas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
public class Course extends BaseModel{
    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(15) DEFAULT 'DIPLOMA'")
    private CourseLevel courseLevel;

    public Course() {}

    @Builder
    public Course(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String name, CourseLevel courseLevel) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.courseLevel = courseLevel;
    }
}
