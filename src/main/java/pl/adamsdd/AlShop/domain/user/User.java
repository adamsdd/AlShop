package pl.adamsdd.AlShop.domain.user;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public boolean enabled;
    public boolean tokenExpired;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    public Collection<Role> roles;
}
