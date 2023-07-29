package elite.sas.core.api.dto;

import elite.sas.core.entities.Student;

public record StudentDTO(String id, UserDTO user, String admissionNumber, CourseDTO course) {
    public static StudentDTO fromModel(Student student) {
        return new StudentDTO(student.getId().toString(), UserDTO.fromModel(student.getAppUser()), student.getAdmissionNumber(), CourseDTO.fromModel(student.getCourse()));
    }
}
