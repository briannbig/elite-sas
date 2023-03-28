package elite.sas.api.params;

import elite.sas.entities.UserType;
import lombok.*;

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

}
