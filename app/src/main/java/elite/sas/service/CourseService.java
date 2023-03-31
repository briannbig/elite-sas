package elite.sas.service;

import elite.sas.entities.Course;
import elite.sas.repository.CourseRepository;
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

    public List<Course> getAllCourses() {
        return  courseRepository.findAll();
    }

    public Optional<Course> getCourseById(String courseId) {
        return courseRepository.findById(UUID.fromString(courseId));
    }

    public Optional<Course> getCourseByName(String courseName) {
        return getAllCourses().stream().filter(c -> Objects.equals(c.getName(), courseName)).findAny();
    }

}
