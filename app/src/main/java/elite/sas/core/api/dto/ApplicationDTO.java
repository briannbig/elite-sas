package elite.sas.core.api.dto;

public record ApplicationDTO(String id, UserDTO user, ListingDTO listing, String application, String schoolLetterUrl,
                             String cvUrl) {
}
