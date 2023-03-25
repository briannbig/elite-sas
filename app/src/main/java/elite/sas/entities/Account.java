package elite.sas.entities;

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
    private User user;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return user.getUserName();
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
    public Account(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String password, User user, Collection<? extends GrantedAuthority> authorities) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.password = password;
        this.user = user;
    }

    private Account(CustomBuilder customBuilder) {
        this.password = customBuilder.password;
        this.user = customBuilder.user;
    }

    public static final class CustomBuilder {
        private User user;
        private String password;

        public CustomBuilder setuser(User user) {
            this.user = user;
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
