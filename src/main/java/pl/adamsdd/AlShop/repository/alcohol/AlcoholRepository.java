package pl.adamsdd.AlShop.repository.alcohol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.adamsdd.AlShop.domain.alcohol.Alcohol;

@NoRepositoryBean
public interface AlcoholRepository<T extends Alcohol> extends JpaRepository<T, Long> {

}
