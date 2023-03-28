package elite.sas.api.params;

import lombok.*;

import java.util.UUID;

@Getter @Setter
public abstract class Params {
    private UUID tenantId;
}
