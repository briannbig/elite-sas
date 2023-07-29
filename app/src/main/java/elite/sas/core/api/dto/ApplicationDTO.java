package elite.sas.core.api.dto;

import elite.sas.core.entities.Application;

public record ApplicationDTO(String id, UserDTO user, ListingDTO listing, String application, String schoolLetterUrl,
                             String cvUrl) {

    public static ApplicationDTO fromModel(Application application) {
        return new ApplicationDTO(application.getId().toString(), UserDTO.fromModel(application.getApplicant()), ListingDTO.fromModel(application.getListing()), application.getApplication(), application.getSchoolLetterUrl(), application.getCvUrl());
    }
}
