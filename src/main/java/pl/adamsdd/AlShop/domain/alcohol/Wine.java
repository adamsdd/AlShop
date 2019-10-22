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
public class Wine extends Alcohol {

    @Enumerated(EnumType.STRING)
    public WineType wineType;

    public Wine() {

    }

    @JsonCreator
    public Wine(Long id, String name, String description, String country, String city, Company company, BigDecimal rate, byte[] image, WineType wineType) {
        super(id, name, description, country, city, company, rate, image);
        this.wineType = wineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Wine wine = (Wine) o;
        return wineType == wine.wineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wineType);
    }

    @Override
    public String toString() {
        return "Wine{" +
                "wineType=" + wineType +
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
