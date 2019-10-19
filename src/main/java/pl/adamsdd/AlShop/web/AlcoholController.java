package pl.adamsdd.AlShop.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adamsdd.AlShop.domain.Alcohol;

import java.util.ArrayList;
import java.util.List;

@RestController("/alcohol")
public class AlcoholController {

    @GetMapping
    public List<Alcohol> getAll() {
        List<Alcohol> alcoholList = new ArrayList<>();
        alcoholList.add(new Alcohol(1L, "Piwo"));
        alcoholList.add(new Alcohol(2L, "Wino"));
        alcoholList.add(new Alcohol(3L, "Gówno"));

        return alcoholList;
    }
}
