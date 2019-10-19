package pl.adamsdd.AlShop.domain.alcohol;

import javax.persistence.*;

@Entity
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public final String name;
    public final String description;
    public final byte[] image;

    public Alcohol(Long id, String name, String description, byte[] image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
