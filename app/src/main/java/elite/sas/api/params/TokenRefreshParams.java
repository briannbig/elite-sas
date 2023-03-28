package elite.sas.api.params;

import lombok.*;

@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenRefreshParams{
    String refreshToken;
}
