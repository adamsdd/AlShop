package pl.adamsdd.AlShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adamsdd.AlShop.domain.alcohol.Alcohol;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {

}
