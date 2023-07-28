package elite.sas.core.api.dto;

import java.time.LocalDateTime;

public record ListingDTO(String id, TenantDTO company, CourseDTO course, String attachmentPeriod, String description,
                         LocalDateTime applicationDeadline) {

}
