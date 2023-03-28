package elite.sas.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity(name = "app_user")
@Setter @Getter
public class AppUser extends BaseModel {

    @ManyToOne
    private Tenant tenant;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String userName;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'STUDENT'")
    private UserType userType;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_has_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles;

    public AppUser() {}

    @Builder
    public AppUser(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Tenant tenant, String email, String userName, String firstName, String lastName, UserType userType) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.tenant = tenant;
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }
}
