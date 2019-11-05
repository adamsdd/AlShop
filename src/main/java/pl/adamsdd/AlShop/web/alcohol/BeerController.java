package pl.adamsdd.AlShop.web.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.adamsdd.AlShop.domain.alcohol.Beer;
import pl.adamsdd.AlShop.domain.alcohol.BeerType;
import pl.adamsdd.AlShop.service.alcohol.BeerService;

import java.util.List;

@RestController
public class BeerController {

    private BeerService service;

    @Autowired
    public BeerController(BeerService service) {
        this.service = service;
    }

    @GetMapping("/beers")
    public List<Beer> getAllWithImages() {
        return service.getAll();
    }

    @GetMapping("/beer/{id}")
    public Beer getAlcohol(@PathVariable Long id) {
        return service.getAlcohol(id);
    }

    @PostMapping(value = "/beer", consumes = {"application/json"})
    public void addNew(@RequestBody Beer Beer) {
        service.save(Beer);
    }

    @PutMapping("/beer/{id}")
    public void update(@PathVariable Long id, @RequestBody Beer Beer) {
        service.update(id, Beer);
    }

    @DeleteMapping("/beer/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/beer-types")
    public List<BeerType> getBeerTypes() {
        return service.getBeerTypes();
    }
}
