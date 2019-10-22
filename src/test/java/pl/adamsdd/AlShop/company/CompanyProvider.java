package pl.adamsdd.AlShop.company;

import pl.adamsdd.AlShop.domain.company.Company;
import pl.adamsdd.AlShop.domain.company.PreferContactForm;

public class CompanyProvider {

    public static Company companyWithId() {
        return new Company(1L, "Test Company", null, null, null, PreferContactForm.NUMBER, null, null, null, null);
    }
}
