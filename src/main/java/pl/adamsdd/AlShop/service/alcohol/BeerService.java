package pl.adamsdd.AlShop.service.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adamsdd.AlShop.domain.alcohol.Beer;
import pl.adamsdd.AlShop.repository.alcohol.BeerRepository;

@Service
public class BeerService extends AlcoholService<Beer> {

    @Autowired
    public BeerService(BeerRepository repository) {
        super(repository);
    }
}
