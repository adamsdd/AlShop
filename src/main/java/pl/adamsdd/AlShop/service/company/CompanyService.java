package pl.adamsdd.AlShop.service.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.adamsdd.AlShop.domain.company.Company;
import pl.adamsdd.AlShop.domain.company.PreferredContactMethod;
import pl.adamsdd.AlShop.repository.company.CompanyRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> getAll() {
        return repository.findAll();
    }

    public Company save(Company company) {
        Assert.notNull(company, "Company cannot be null");

        return repository.save(company);
    }

    public Company update(Long id, Company company) {
        Assert.notNull(id, "Id cannot be null");

        return repository.save(company);
    }

    public void delete(Long id) {
        Company savedCompany = getCompany(id);

        repository.delete(savedCompany);
    }

    public Company getCompany(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find company with id = " + id));
    }

    public List<PreferredContactMethod> getContactMethods() {
        return Arrays.asList(PreferredContactMethod.values());
    }
}
