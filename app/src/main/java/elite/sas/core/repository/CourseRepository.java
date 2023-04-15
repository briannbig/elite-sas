package elite.sas.core.repository;

import elite.sas.core.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    Optional<Course> findByName(String name);

    List<Course> findByCourseLevel(String courseLevel);
}
