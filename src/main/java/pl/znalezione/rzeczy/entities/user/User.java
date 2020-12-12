package pl.znalezione.rzeczy.entities.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.znalezione.rzeczy.entities.user.enums.Roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id_user;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    @Column(columnDefinition = "boolean default false")
    private boolean is_blocked;
    private Roles roles;
    private long id_photo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
        return !is_blocked;
    }

}
