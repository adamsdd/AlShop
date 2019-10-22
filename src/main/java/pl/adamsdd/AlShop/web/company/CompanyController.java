package pl.adamsdd.AlShop.web.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.adamsdd.AlShop.domain.company.Company;
import pl.adamsdd.AlShop.service.company.CompanyService;

import java.util.List;

@RestController
public class CompanyController {

    private CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("/companies")
    public List<Company> getAll() {
        return service.getAll();
    }

    @GetMapping("/company/{id}")
    public Company getAlcohol(@PathVariable Long id) {
        return service.getCompany(id);
    }

    @PostMapping("/company")
    public void addNew(@RequestBody Company company) {
        service.save(company);
    }

    @PutMapping("/company/{id}")
    public void update(@PathVariable Long id, @RequestBody Company company) {
        service.update(id, company);
    }

    @DeleteMapping("/company/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
