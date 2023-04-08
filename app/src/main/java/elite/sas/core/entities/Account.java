package elite.sas.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Brian Barasa
 */
@Entity
@Getter @Setter
public class Account extends BaseModel implements UserDetails {

    @JsonIgnore
    private String password;

    @OneToOne
    private AppUser appUser;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return appUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return appUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Account() {}

    @Builder
    public Account(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String password, AppUser appUser, Collection<? extends GrantedAuthority> authorities) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.password = password;
        this.appUser = appUser;
    }

    private Account(CustomBuilder customBuilder) {
        this.password = customBuilder.password;
        this.appUser = customBuilder.appUser;
    }

    public static final class CustomBuilder {
        private AppUser appUser;
        private String password;

        public CustomBuilder setuser(AppUser appUser) {
            this.appUser = appUser;
            return this;
        }
        public CustomBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
