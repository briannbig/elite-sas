package elite.sas.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * @author Brian Barasa
 */

@Entity
@Setter @Getter
public class Role extends BaseModel {
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "roles", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<AppUser> usersWithRole;


    public Role() {}

    @Builder
    public Role(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, RoleName roleName, Set<AppUser> usersWithRole) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.roleName = roleName;
        this.usersWithRole = usersWithRole;
    }
}
