package pl.adamsdd.AlShop.service.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adamsdd.AlShop.domain.alcohol.Beer;
import pl.adamsdd.AlShop.domain.alcohol.BeerType;
import pl.adamsdd.AlShop.repository.alcohol.BeerRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class BeerService extends AlcoholService<Beer> {

    @Autowired
    public BeerService(BeerRepository repository) {
        super(repository);
    }

    public List<BeerType> getBeerTypes() {
        return Arrays.asList(BeerType.values());
    }
}
