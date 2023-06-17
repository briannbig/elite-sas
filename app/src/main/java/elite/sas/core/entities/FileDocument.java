package elite.sas.core.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class FileDocument extends BaseModel {

    @ManyToOne
    AppUser appUser;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FileDocumentType documentType;

    private String name;

    private String locationUrl;

}
