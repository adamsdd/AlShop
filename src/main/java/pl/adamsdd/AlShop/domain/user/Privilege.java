package pl.adamsdd.AlShop.domain.user;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;

    @ManyToMany(mappedBy = "privileges")
    public Collection<Role> roles;
}
