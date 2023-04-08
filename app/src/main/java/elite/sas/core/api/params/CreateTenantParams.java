package elite.sas.core.api.params;

import elite.sas.core.entities.TenantType;
import lombok.*;


@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class CreateTenantParams{
    private String name;
    private String location;
    private String telephone;
    private String email;
    private TenantType tenantType;


}
