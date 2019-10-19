package pl.adamsdd.AlShop.domain.alcohol;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    public String description;
    public byte[] image;

    public Alcohol() {
    }

    public Alcohol(Long id, String name, String description, byte[] image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alcohol alcohol = (Alcohol) o;
        return Objects.equals(id, alcohol.id) &&
                Objects.equals(name, alcohol.name) &&
                Objects.equals(description, alcohol.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "Alcohol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
