package pl.adamsdd.AlShop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Entity
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column
    public String name;

    public Alcohol(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Alcohol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
