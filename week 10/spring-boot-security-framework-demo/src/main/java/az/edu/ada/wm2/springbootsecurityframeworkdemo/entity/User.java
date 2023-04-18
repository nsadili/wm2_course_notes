package az.edu.ada.wm2.springbootsecurityframeworkdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.graph.GraphNode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String roles;
    @Transient
    private List<String> authorities = Arrays.asList("ROLE_USER");
    @Transient
    private List<GrantedAuthority> grantedAuthorities =
            Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));

    public List<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User addRole(GrantedAuthority authority){
        this.grantedAuthorities.add(authority);
        return this;
    }
    @PrePersist
    @PreUpdate
    private void saveRoles(){
        this.roles = String.join(";", this.authorities);
    }

    private void readRoles(){
        this.authorities = Arrays.stream(this.roles.split(";")).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
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

}
