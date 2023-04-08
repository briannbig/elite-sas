package elite.sas.core.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Getter @Setter
public class Tenant extends BaseModel{

    @Column(unique = true)
    private String name;
    private String location;

    @Column(unique = true)
    private String telephone;
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'SCHOOL'")
    private TenantType tenantType;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<AppUser> users;

    public Tenant() {}

    @Builder

    public Tenant(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String name, String location, String telephone, String email, TenantType tenantType) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.location = location;
        this.telephone = telephone;
        this.email = email;
        this.tenantType = tenantType;
    }
}
