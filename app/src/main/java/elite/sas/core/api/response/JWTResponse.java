package elite.sas.core.api.response;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class JWTResponse {
    private String access_token;
    private String refresh_token;
    @Builder.Default
    private String type = "Bearer";
    private UUID id;
    private String username;
    private String email;
    private List<String> roles;
}
