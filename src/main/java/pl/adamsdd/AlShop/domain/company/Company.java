package pl.adamsdd.AlShop.domain.company;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Company {

    @Id
    @SequenceGenerator(name = "companySEQ", sequenceName = "companySEQ", allocationSize = 10000)
    @GeneratedValue(generator = "companySEQ")
    public Long id;

    public String name;
    public String bossName;
    public String bossSecondName;
    public String bossSurname;
    public String country;
    public String city;
    public String postCode;
    @Enumerated(EnumType.STRING)
    public PreferredContactMethod preferredContactMethod;
    public String contactNumber;
    public String mail;
    public LocalDate dateFrom;
    public LocalDate dateTo;

    public Company() {
    }

    @JsonCreator
    public Company(Long id, String name, String bossName, String bossSecondName, String bossSurname, String country, String city, String postCode, PreferredContactMethod preferredContactMethod,
                   String contactNumber, String mail, LocalDate dateFrom, LocalDate dateTo) {
        this.id = id;
        this.name = name;
        this.bossName = bossName;
        this.bossSecondName = bossSecondName;
        this.bossSurname = bossSurname;
        this.country = country;
        this.city = city;
        this.postCode = postCode;
        this.preferredContactMethod = preferredContactMethod;
        this.contactNumber = contactNumber;
        this.mail = mail;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(name, company.name) &&
                Objects.equals(country, company.country) &&
                Objects.equals(city, company.city) &&
                Objects.equals(postCode, company.postCode) &&
                preferredContactMethod == company.preferredContactMethod &&
                Objects.equals(contactNumber, company.contactNumber) &&
                Objects.equals(mail, company.mail) &&
                Objects.equals(dateFrom, company.dateFrom) &&
                Objects.equals(dateTo, company.dateTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, city, postCode, preferredContactMethod, contactNumber, mail, dateFrom, dateTo);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", PreferredContactMethod=" + preferredContactMethod +
                ", contactNumber='" + contactNumber + '\'' +
                ", mail='" + mail + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
