package elite.sas.api.params;

import elite.sas.entities.Role;
import elite.sas.entities.UserType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class CreateUserParams {
    private UUID tenantId;
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private UserType userType;
    private String password;
    private String passwordConfirm;
    @Builder.Default
    private List<Role> roles = new ArrayList<>();

}
