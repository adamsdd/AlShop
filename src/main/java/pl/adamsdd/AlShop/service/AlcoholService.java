package pl.adamsdd.AlShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.adamsdd.AlShop.domain.alcohol.Alcohol;
import pl.adamsdd.AlShop.repository.AlcoholRepository;

import java.util.List;

@Service
public class AlcoholService {

    private final AlcoholRepository repository;

    @Autowired
    public AlcoholService(AlcoholRepository repository) {
        this.repository = repository;
    }

    public Alcohol save(Alcohol alcohol) {
        Assert.notNull(alcohol, "Alcohol cannot be null");

        return repository.save(alcohol);
    }

    public Alcohol update(Long id, Alcohol alcohol) {
        Assert.notNull(id, "Id cannot be null");

        return repository.save(alcohol);
    }

    public void delete(Long id) {
        Alcohol savedAlcohol = getAlcohol(id);

        repository.delete(savedAlcohol);
    }

    public List<Alcohol> getAll() {
        return repository.findAll();
    }

    public Alcohol getAlcohol(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find alcohol with id = " + id));
    }
}
