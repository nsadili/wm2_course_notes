package webII.com.example.Web.II.Project2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String email;

    private String roles; // ROLE_USER, ROLE_ADMIN

    @Transient
    private List<String> grantedAuthorities = Arrays.asList("ROLE_USER");

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User addRole(String authority){
        this.grantedAuthorities.add(authority);
        return this;
    }

    @PrePersist
    @PreUpdate
    public void saveRoles(){
        this.roles = String.join(";",this.grantedAuthorities);
    }

    @PostLoad
    private void readRoles(){
       this.grantedAuthorities = Arrays.stream(this.roles.split(";")).collect(Collectors.toList());
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
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
