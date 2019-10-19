package pl.adamsdd.AlShop.alcohol;

import pl.adamsdd.AlShop.domain.alcohol.Alcohol;

public class AlcoholProvider {

    public static Alcohol getAlcoholWithId(Long id) {
        return new Alcohol(id, "Harnas", "Z puchy", new byte[0]);
    }
}
