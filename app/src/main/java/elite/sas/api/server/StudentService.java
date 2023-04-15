package elite.sas.api.server;

import elite.sas.api.ApiUtil;
import elite.sas.api.exceptions.ModelConversionException;
import elite.sas.api.exceptions.UnRetriableException;
import elite.sas.api.grpc.CommonsProto;
import elite.sas.api.grpc.CourseServiceProto;
import elite.sas.api.grpc.studentServiceGrpc;
import elite.sas.core.api.params.CreateStudentParams;
import elite.sas.core.entities.Course;
import elite.sas.core.entities.Student;
import elite.sas.core.service.CourseService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static elite.sas.api.ApiUtil.*;

@Slf4j
@RequiredArgsConstructor
public class StudentService extends studentServiceGrpc.studentServiceImplBase {

    private final elite.sas.core.service.StudentService studentService;
    private final CourseService courseService;

    @Override
    public void registerStudent(CourseServiceProto.RegisterStudentRequest request, StreamObserver<CourseServiceProto.Student> responseObserver) {

        if (Objects.isNull(Objects.isNull(request.getTenantId()) || Objects.isNull(request.getAdmissionNumber()) ||
                Objects.isNull(request.getCourseId())) || Objects.isNull(request.getEmail()) ||
                Objects.isNull(request.getFirstName()) || Objects.isNull(request.getLastName()) ||
                Objects.isNull(request.getPassword()) || Objects.isNull(request.getPasswordConfirm())
        ) {
            responseObserver.onError(new UnRetriableException("Missing required field(s)"));
            log.debug("Missing required field(s) for request {}", request);
            return;
        }

        CreateStudentParams params = CreateStudentParams.builder()
                .tenantId(UUID.fromString(request.getTenantId()))
                .email(request.getEmail())
                .admissionNumber(request.getAdmissionNumber())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .courseId(UUID.fromString(request.getCourseId()))
                .password(request.getPassword())
                .passwordConfirm(request.getPasswordConfirm())
                .build();

        Optional<Student> optionalStudent = studentService.registerStudent(params);

        if (optionalStudent.isEmpty()) {
            responseObserver.onError(new UnRetriableException("Could not register student"));
            return;
        }

        try {
            responseObserver.onNext(studentToApi(optionalStudent.get()));
        } catch (ModelConversionException e) {
            log.debug("Conversion error: {}", e);
            responseObserver.onError(e);
            return;
        }

        responseObserver.onCompleted();

    }

    @Override
    public void getAllStudents(CommonsProto.Empty request, StreamObserver<CourseServiceProto.Student> responseObserver) {
        studentService.getAllStudents().forEach(
                student -> {
                    try {
                        responseObserver.onNext(studentToApi(student));
                    } catch (ModelConversionException e) {
                        log.debug("Conversion error: {}", e);
                    }
                }
        );
        responseObserver.onCompleted();
    }

    @Override
    public void getStudent(CourseServiceProto.SearchStudentParams request, StreamObserver<CourseServiceProto.Student> responseObserver) {

        if (Objects.nonNull(request.getId())) {
            Optional<Student> optionalStudent = studentService.getStudentById(request.getId());
            if (optionalStudent.isEmpty()) {
                log.debug("student with id {} could not be found!", request.getId());
                responseObserver.onError(new UnRetriableException("student with given id could not be found"));
                return;
            }

            try {
                responseObserver.onNext(studentToApi(optionalStudent.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(e);
                return;
            }

            responseObserver.onCompleted();
        }

        if (Objects.nonNull(request.getAdmissionNumber())) {

            Optional<Student> optionalStudent = studentService.getStudentByAdmissionNumber(request.getId());
            if (optionalStudent.isEmpty()) {
                log.debug("student with admission number {} could not be found!", request.getAdmissionNumber());
                responseObserver.onError(new UnRetriableException("student with given admission number could not be found"));
                return;
            }

            try {
                responseObserver.onNext(studentToApi(optionalStudent.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(e);
                return;
            }

            responseObserver.onCompleted();

        }

        if (Objects.nonNull(request.getAppUserId())) {

            Optional<Student> optionalStudent = studentService.getStudentByAppUserId(request.getAppUserId());
            if (optionalStudent.isEmpty()) {
                log.debug("student with app user having id {} could not be found!", request.getAppUserId());
                responseObserver.onError(new UnRetriableException("student with app user of given id could not be found"));
                return;
            }

            try {
                responseObserver.onNext(studentToApi(optionalStudent.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(e);
                return;
            }

            responseObserver.onCompleted();
        }

        log.debug("could not find suitable parameteres for getting student. {}", request);
        responseObserver.onError(new UnRetriableException("could not find suitable parameteres for getting student"));

    }

    @Override
    public void getStudents(CourseServiceProto.SearchStudentParams request, StreamObserver<CourseServiceProto.Student> responseObserver) {
        if (Objects.nonNull(request.getCourseId())) {
            studentService.getAllStudentsForCourse(request.getCourseId()).forEach(
                    student -> {
                        try {
                            responseObserver.onNext(studentToApi(student));
                        } catch (ModelConversionException e) {
                            log.debug("Conversion error: {}", e);
                        }
                    }
            );
        }

        if (Objects.nonNull(request.getSchoolId())) {
            studentService.getAllStudentsForSchool(request.getSchoolId()).forEach(
                    student -> {
                        try {
                            responseObserver.onNext(studentToApi(student));
                        } catch (ModelConversionException e) {
                            log.debug("Conversion error: {}", e);
                        }
                    }
            );
        }

        responseObserver.onCompleted();
    }

    /**
     * updates student. Only update course
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void updateStudent(CourseServiceProto.UpdateStudentRequest request, StreamObserver<CourseServiceProto.Student> responseObserver) {
        if (Objects.isNull(request.getId()) || Objects.isNull(request.getCourse())) {
            log.debug("missing required field(s) for request: {}", request);
            responseObserver.onError(new UnRetriableException("Missing required field(s) in the request"));
            return;
        }

        Optional<Student> optionalStudent = studentService.updateStudent(request.getId(), request.getCourse().getId());

        if (optionalStudent.isEmpty()) {
            log.debug("could not update student for request {}", request);
            responseObserver.onError(new UnRetriableException("could not update student, check student id and/or course"));
            return;
        }

        try {
            responseObserver.onNext(studentToApi(optionalStudent.get()));
        } catch (ModelConversionException e) {
            log.debug("Conversion error: {}", e);
            responseObserver.onError(e);
            return;
        }

        responseObserver.onCompleted();


    }

    @Override
    public void addCourse(CourseServiceProto.Course request, StreamObserver<CourseServiceProto.Course> responseObserver) {
        if (Objects.isNull(request.getName()) || Objects.isNull(request.getCourseLevel())) {
            responseObserver.onError(new UnRetriableException("Missing required field(s)"));
            log.debug("Missing required field(s) for request {}", request);
            return;
        }

    }

    @Override
    public void getAllCourses(CommonsProto.Empty request, StreamObserver<CourseServiceProto.Course> responseObserver) {
        courseService.getAllCourses().forEach(
                course -> {
                    try {
                        responseObserver.onNext(courseToApi(course));
                    } catch (ModelConversionException e) {
                        log.debug("Conversion error: {}", e);
                    }
                }
        );
        responseObserver.onCompleted();
    }

    @Override
    public void getCourse(CourseServiceProto.SearchCourseParams request, StreamObserver<CourseServiceProto.Course> responseObserver) {

        if (Objects.nonNull(request.getId())) {
            Optional<Course> optionalCourse = courseService.getCourseById(request.getId());
            if (optionalCourse.isEmpty()) {
                log.debug("could not find course with id {}", request.getId());
                responseObserver.onError(new UnRetriableException("could not find course with given Id"));
                return;
            }
            try {
                responseObserver.onNext(courseToApi(optionalCourse.get()));
            } catch (ModelConversionException e) {
                responseObserver.onError(e);
                return;
            }
            responseObserver.onCompleted();
        }

        if (Objects.nonNull(request.getName())) {
            Optional<Course> optionalCourse = courseService.getCourseByName(request.getName());
            if (optionalCourse.isEmpty()) {
                log.debug("could not find course with name {}", request.getName());
                responseObserver.onError(new UnRetriableException("could not find course with given name"));
                return;
            }
            try {
                responseObserver.onNext(courseToApi(optionalCourse.get()));
            } catch (ModelConversionException e) {
                responseObserver.onError(e);
                return;
            }
            responseObserver.onCompleted();
        }

        log.debug("missing required param(s) for request {}", request);
        responseObserver.onError(new UnRetriableException("Missing required param(s) in the request"));

    }

    /**
     * get courses by level
     *
     * @param request          must have course level for filtering
     * @param responseObserver
     */
    @Override
    public void getCourses(CourseServiceProto.SearchCourseParams request, StreamObserver<CourseServiceProto.Course> responseObserver) {
        if (Objects.isNull(request.getCourseLevel())) {
            log.debug("missing course level in the request: {}", request);
            responseObserver.onError(new UnRetriableException("missing course level in request"));
            return;
        }

        courseService.getAllCoursesForLevel(ApiUtil.courseLevelFromApi(request.getCourseLevel())).forEach(
                course -> {
                    try {
                        responseObserver.onNext(courseToApi(course));
                    } catch (ModelConversionException e) {
                        log.debug("Conversion error: {}", e);
                    }
                }
        );
        responseObserver.onCompleted();
    }

    @Override
    public void updateCourse(CourseServiceProto.UpdateCourseRequest request, StreamObserver<CourseServiceProto.Course> responseObserver) {
        if (Objects.isNull(request.getId())) {
            log.debug("missing course id in the request: {}", request);
            responseObserver.onError(new UnRetriableException("missing course id in request"));
            return;
        }

        Optional<Course> optionalCourse = courseService.updateCourse(request.getId(), request.getName(), courseLevelFromApi(request.getCourseLevel()));

        if (optionalCourse.isEmpty()) {
            log.debug("could not update course with id: {}", request.getId());
            responseObserver.onError(new UnRetriableException("Could not update course"));
            return;
        }

        try {
            responseObserver.onNext(courseToApi(optionalCourse.get()));
        } catch (ModelConversionException e) {
            responseObserver.onError(e);
            return;
        }
        responseObserver.onCompleted();

    }
}