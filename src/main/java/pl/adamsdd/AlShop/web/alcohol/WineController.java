package pl.adamsdd.AlShop.web.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.adamsdd.AlShop.domain.alcohol.Wine;
import pl.adamsdd.AlShop.service.alcohol.WineService;

import java.util.List;

@RestController
public class WineController {

    private WineService service;

    @Autowired
    public WineController(WineService service) {
        this.service = service;
    }

    @GetMapping("/wines")
    public List<Wine> getAllWithImages() {
        return service.getAll();
    }

    @GetMapping("/wine/{id}")
    public Wine getAlcohol(@PathVariable Long id) {
        return service.getAlcohol(id);
    }

    @PostMapping("/wine")
    public void addNew(@RequestBody Wine wine) {
        service.save(wine);
    }

    @PutMapping("/wine/{id}")
    public void update(@PathVariable Long id, @RequestBody Wine wine) {
        service.update(id, wine);
    }

    @DeleteMapping("/wine/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
