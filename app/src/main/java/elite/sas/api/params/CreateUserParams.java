package elite.sas.api.params;

import elite.sas.entities.UserType;
import lombok.*;


@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserParams extends Params{
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private UserType userType;
    private String password;
    private String passwordConfirm;
}
