package elite.sas.api.params;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter
public class CreateStudentParams {

    private UUID tenantId;
    private UUID userId;
    private UUID courseId;

}
