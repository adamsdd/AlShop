package pl.adamsdd.AlShop.company;

import pl.adamsdd.AlShop.domain.company.Company;
import pl.adamsdd.AlShop.domain.company.PreferredContactMethod;

public class CompanyProvider {

    public static Company companyWithId() {
        return new Company(1L, "TestA Company", "Stefan", "Eugeniusz", "Batory", null, null, null, PreferredContactMethod.NUMBER, null, null, null, null);
    }
}
