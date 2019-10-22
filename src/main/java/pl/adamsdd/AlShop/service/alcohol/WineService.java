package pl.adamsdd.AlShop.service.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adamsdd.AlShop.domain.alcohol.Wine;
import pl.adamsdd.AlShop.repository.alcohol.WineRepository;

@Service
public class WineService extends AlcoholService<Wine> {

    @Autowired
    public WineService(WineRepository repository) {
        super(repository);
    }
}
