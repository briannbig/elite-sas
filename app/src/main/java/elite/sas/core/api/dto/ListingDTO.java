package elite.sas.core.api.dto;


import elite.sas.core.entities.AttachmentPeriod;
import elite.sas.core.entities.Listing;

import java.time.LocalDateTime;

public record ListingDTO(String id, String companyId, String companyName, CourseDTO course,
                         AttachmentPeriod attachmentPeriod,
                         String description, LocalDateTime applicationDeadline) {

    public static ListingDTO fromModel(Listing listing) {
        return new ListingDTO(listing.getId().toString(), listing.getTenant().getId().toString(), listing.getTenant().getName(), CourseDTO.from(listing.getCourse()), listing.getAttachmentPeriod(), listing.getDescription(), listing.getDeadline());
    }

}
