package pl.adamsdd.AlShop.service.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adamsdd.AlShop.domain.alcohol.Wine;
import pl.adamsdd.AlShop.domain.alcohol.WineType;
import pl.adamsdd.AlShop.repository.alcohol.WineRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class WineService extends AlcoholService<Wine> {

    @Autowired
    public WineService(WineRepository repository) {
        super(repository);
    }

    public List<WineType> getWineTypes() {
        return Arrays.asList(WineType.values());
    }
}
