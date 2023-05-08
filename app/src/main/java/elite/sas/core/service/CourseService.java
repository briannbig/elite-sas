package elite.sas.core.service;

import elite.sas.core.entities.Course;
import elite.sas.core.entities.CourseLevel;
import elite.sas.core.repository.CourseRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    public Optional<Course> addCourse(Course course) {
        if (Objects.isNull(course.getName()) || Objects.isNull(course.getCourseLevel())) {
            log.info("Course name or level not specified");
            return Optional.empty();
        }

        Optional<Course> optionalCourse = courseRepository.findByName(course.getName());
        if (optionalCourse.isPresent()) {
            log.debug("course with name {} not found", course.getName());
            return Optional.empty();
        }

        return Optional.of(courseRepository.save(course));

    }

    public Optional<Course> getCourseById(String courseId) {
        return courseRepository.findById(UUID.fromString(courseId));
    }

    public Optional<Course> getCourseByName(String courseName) {
        return courseRepository.findByName(courseName);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getAllCoursesForLevel(CourseLevel courseLevel) {
        return courseRepository.findByCourseLevel(courseLevel.name());
    }

    public Optional<Course> updateCourse(String courseId, @Nullable String courseName, @Nullable CourseLevel courseLevel) {
        Optional<Course> optionalCourse = courseRepository.findById(UUID.fromString(courseId));
        if (optionalCourse.isEmpty()) {
            log.debug("course with id {} not found", courseId);
            return Optional.empty();
        }


        if (Objects.nonNull(courseName) && Objects.equals(optionalCourse.get().getName(), courseName)) {
            optionalCourse.get().setName(courseName);
        }

        if (Objects.nonNull(courseLevel) &&
                Objects.equals(optionalCourse.get().getName().toLowerCase(), courseLevel.name().toLowerCase())) {
            optionalCourse.get().setCourseLevel(courseLevel);
        }

        return Optional.of(courseRepository.save(optionalCourse.get()));

    }

}
