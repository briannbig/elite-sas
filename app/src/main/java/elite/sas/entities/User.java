package elite.sas.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Setter @Getter
public class User extends BaseModel {

    @ManyToOne
    private Tenant tenant;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String userName;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(20) default 'STUDENT'")
    private UserType userType;

    public User() {}

    @Builder
    public User(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Tenant tenant, String email, String userName, String firstName, String lastName, UserType userType) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.tenant = tenant;
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }
}
