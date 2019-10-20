package pl.adamsdd.AlShop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.adamsdd.AlShop.domain.alcohol.Alcohol;
import pl.adamsdd.AlShop.service.AlcoholService;

import java.util.List;

@RestController
public class AlcoholController {

    private final AlcoholService service;

    @Autowired
    public AlcoholController(AlcoholService service) {
        this.service = service;
    }

    @GetMapping("/alcohols")
    public List<Alcohol> getAllWithImages() {
        return service.getAll();
    }

    @GetMapping("/alcohol/{id}")
    public Alcohol getAlcohol(@PathVariable Long id) {
        return service.getAlcohol(id);
    }

    @PostMapping("/alcohol")
    public Alcohol addNew(@RequestBody Alcohol alcohol) {
        return service.save(alcohol);
    }

    @PutMapping("/alcohol/{id}")
    public Alcohol update(@PathVariable Long id, @RequestBody Alcohol alcohol) {
        return service.update(id, alcohol);
    }

    @DeleteMapping("/alcohol/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
