package pl.adamsdd.AlShop.service.alcohol;

import org.springframework.util.Assert;
import pl.adamsdd.AlShop.domain.alcohol.Alcohol;
import pl.adamsdd.AlShop.repository.alcohol.AlcoholRepository;

import java.util.List;

public abstract class AlcoholService<T extends Alcohol> {

    private final AlcoholRepository<T> repository;

    public AlcoholService(AlcoholRepository<T> repository) {
        this.repository = repository;
    }

    public Alcohol save(T alcohol) {
        Assert.notNull(alcohol, "Alcohol cannot be null");

        return repository.save(alcohol);
    }

    public Alcohol update(Long id, T alcohol) {
        Assert.notNull(id, "Id cannot be null");

        return repository.save(alcohol);
    }

    public void delete(Long id) {
        T savedAlcohol = getAlcohol(id);

        repository.delete(savedAlcohol);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T getAlcohol(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find alcohol with id = " + id));
    }
}
