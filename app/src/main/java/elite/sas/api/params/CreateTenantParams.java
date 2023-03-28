package elite.sas.api.params;

import elite.sas.entities.TenantType;
import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class CreateTenantParams extends Params{

    private String name;
    private String location;
    private String telephone;
    private String email;
    private TenantType tenantType;

}
