package elite.sas.core.api.dto;

import elite.sas.core.entities.AppUser;
import elite.sas.core.entities.Role;
import elite.sas.core.entities.UserType;

import java.util.Set;
import java.util.UUID;

public record UserDTO(UUID id, UUID tenantID, String userName, String firstName, String lastName, String email,
                      UserType userType, Set<Role> roles) {

    public static UserDTO fromModel(AppUser user) {
        return new UserDTO(user.getId(), user.getTenant().getId(), user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getUserType(), user.getRoles());
    }
}
