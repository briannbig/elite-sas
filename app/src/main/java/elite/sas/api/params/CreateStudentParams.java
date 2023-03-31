package elite.sas.api.params;

import elite.sas.entities.UserType;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter
public class CreateStudentParams {

    private UUID tenantId;
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private UserType userType;
    private String password;
    private String passwordConfirm;

    private UUID userId;
    private String admissionNumber;
    private UUID courseId;

}
