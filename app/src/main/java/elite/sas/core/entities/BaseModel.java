package elite.sas.core.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.UUIDJdbcType;

import java.time.LocalDateTime;
import java.util.UUID;


@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public abstract class BaseModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JdbcType(UUIDJdbcType.class)
    private UUID Id;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column
    private LocalDateTime deletedAt;



    @PrePersist
//        generates uuid to persist into db
    void generateId(){
        if(Id==null){
            Id= UUID.randomUUID();
        }
        if(createdAt==null){
            createdAt= LocalDateTime.now();
        }
        if(updatedAt==null){
            updatedAt= LocalDateTime.now();
        }
    }

}
