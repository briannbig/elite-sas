package elite.sas.core.api.dto;

import elite.sas.core.entities.Course;

public record CourseDTO(String id, String name, String courseLevel) {

    public static CourseDTO fromModel(Course course) {
        return new CourseDTO(course.getId().toString(), course.getName(), course.getCourseLevel().name());
    }
}
