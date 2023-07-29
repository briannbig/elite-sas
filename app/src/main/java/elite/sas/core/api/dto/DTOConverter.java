package elite.sas.core.api.dto;

import elite.sas.core.entities.AppUser;

public final class DTOConverter {

    public static UserDTO getUserDTO(AppUser u) {
        return new UserDTO(u.getId(), u.getTenant().getId(), u.getUserName(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getUserType(), u.getRoles());
    }
}
