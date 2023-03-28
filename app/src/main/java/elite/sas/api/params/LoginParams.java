package elite.sas.api.params;

import lombok.*;

@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginParams extends Params{
    String userName;
    String password;
}
