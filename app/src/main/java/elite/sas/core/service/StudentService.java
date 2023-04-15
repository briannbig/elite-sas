package elite.sas.core.service;

import elite.sas.core.api.params.CreateStudentParams;
import elite.sas.core.entities.Course;
import elite.sas.core.entities.Student;
import elite.sas.core.repository.CourseRepository;
import elite.sas.core.repository.StudentRepository;
import elite.sas.core.util.TemporalUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> registerStudent(CreateStudentParams params) {
        return TemporalUtil.studentCreationWorkflow().handle(params);
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(UUID.fromString(id));
    }

    public Optional<Student> getStudentByAppUserId(String id) {
        return studentRepository.findByAppUserId(UUID.fromString(id));
    }

    public Optional<Student> getStudentByAdmissionNumber(String admNumber) {
        return studentRepository.findByAdmissionNumber(UUID.fromString(admNumber));
    }

    public List<Student> getAllStudentsForCourse(String courseId) {
        return studentRepository.findByCourseId(UUID.fromString(courseId));
    }

    public List<Student> getAllStudentsForSchool(String tenantId) {
        return studentRepository.findByAppUserTenantId(UUID.fromString(tenantId));
    }

    /**
     * updates student. Only updates course
     *
     * @param student
     */
    public Optional<Student> updateStudent(String studentId, String courseId) {
        Optional<Student> optionalStudent = studentRepository.findById(UUID.fromString(studentId));

        if (optionalStudent.isEmpty()) {
            log.debug("student with id {} could not be found", studentId);
            return Optional.empty();
        }

        if (!Objects.equals(optionalStudent.get().getCourse().getId(), courseId)) {
            Optional<Course> optionalCourse = courseRepository.findById(UUID.fromString(courseId));
            if (optionalStudent.isEmpty()) {
                log.debug("course with id {} could not be found");
                return Optional.empty();
            }
            optionalStudent.get().setCourse(optionalCourse.get());
            return Optional.of(studentRepository.save(optionalStudent.get()));
        }

        return Optional.empty();

    }


}
