package elite.sas.core.api.dto;

import elite.sas.core.entities.Tenant;
import elite.sas.core.entities.TenantType;

import java.util.List;
import java.util.UUID;

public record TenantDTO(UUID tenantId, String name, String location, String telephone, String email,
                        TenantType tenantType) {
}
