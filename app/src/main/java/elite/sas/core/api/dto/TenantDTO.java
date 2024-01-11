package elite.sas.core.api.dto;

import elite.sas.core.entities.Tenant;
import elite.sas.core.entities.TenantType;

import java.util.UUID;

public record TenantDTO(UUID tenantId, String name, String location, String telephone, String email,
                        String tenantType) {

    public static TenantDTO from(Tenant tenant) {
        return new TenantDTO(tenant.getId(), tenant.getName(), tenant.getLocation(), tenant.getTelephone(), tenant.getEmail(), tenant.getTenantType().name());
    }
}
