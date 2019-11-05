package pl.adamsdd.AlShop.alcohol;

import pl.adamsdd.AlShop.company.CompanyProvider;
import pl.adamsdd.AlShop.domain.alcohol.Alcohol;

import java.math.BigDecimal;

public class AlcoholProvider {

    public static Alcohol getAlcoholWithId(Long id) {
        return new Alcohol(id, "Harnas", "Z puchy", null, null, CompanyProvider.companyWithId(), BigDecimal.TEN, "");
    }
}
