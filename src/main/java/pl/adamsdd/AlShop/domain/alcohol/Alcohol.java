package pl.adamsdd.AlShop.domain.alcohol;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.adamsdd.AlShop.domain.company.Company;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    public String description;
    public String country;
    public String city;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Company company;

    public BigDecimal rate;
    public byte[] image;

    public Alcohol() {
    }

    @JsonCreator
    public Alcohol(Long id, String name, String description, String country, String city, Company company, BigDecimal rate, byte[] image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.city = city;
        this.company = company;
        this.rate = rate;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alcohol alcohol = (Alcohol) o;
        return Objects.equals(id, alcohol.id) &&
                Objects.equals(name, alcohol.name) &&
                Objects.equals(description, alcohol.description) &&
                Objects.equals(country, alcohol.country) &&
                Objects.equals(city, alcohol.city) &&
                Objects.equals(company, alcohol.company) &&
                Objects.equals(rate, alcohol.rate) &&
                Arrays.equals(image, alcohol.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, description, country, city, company, rate);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "Alcohol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", company=" + company +
                ", rate=" + rate +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
