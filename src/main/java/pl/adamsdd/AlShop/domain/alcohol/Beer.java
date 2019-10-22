package pl.adamsdd.AlShop.domain.alcohol;

import com.fasterxml.jackson.annotation.JsonCreator;
import pl.adamsdd.AlShop.domain.company.Company;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Beer extends Alcohol {

    @Enumerated(EnumType.STRING)
    public BeerType beerType;

    public Beer() {
    }

    @JsonCreator
    public Beer(Long id, String name, String description, String country, String city, Company company, BigDecimal rate, byte[] image, BeerType beerType) {
        super(id, name, description, country, city, company, rate, image);
        this.beerType = beerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Beer beer = (Beer) o;
        return beerType == beer.beerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), beerType);
    }

    @Override
    public String toString() {
        return "Beer{" +
                "beerType=" + beerType +
                ", id=" + id +
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
