package elite.sas.api.params;

import lombok.*;

import java.util.UUID;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentParams extends Params{

    private UUID userId;
    private UUID courseId;

}
