package pl.adamsdd.AlShop.alcohol


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.adamsdd.AlShop.AlShopApplication
import pl.adamsdd.AlShop.domain.alcohol.Alcohol
import pl.adamsdd.AlShop.service.AlcoholService
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
@SpringBootTest(classes = AlShopApplication.class)
class AlcoholIntegrationTest extends Specification {

    private final Long ALCOHOL_ID = 1L
    private final String NEW_ALCOHOL_NAME = "WARKA";

    @Autowired
    private AlcoholService service

    void "Should save new alcohol"() {
        given: "new Alcohol"
        Alcohol newAlcohol = AlcoholProvider.getAlcoholWithId(ALCOHOL_ID)
        and: "alcohol service"
        service

        when: "user saved new alcohol"
        service.save(newAlcohol)

        then: "user can get saved alcohol"
        Alcohol savedAlcohol = service.getAlcohol(newAlcohol.id)
        and: "no exception throw"
        noExceptionThrown()
        and: "savedAlcohol is same like newAlcohol"
        savedAlcohol == newAlcohol
    }

    void "Should update exist alcohol"() {
        given: "existing alcohol in database"
        Alcohol savedAlcohol = service.getAlcohol(ALCOHOL_ID)
        and:
        String oldAlcoholName = savedAlcohol.name

        when: "user changed alcohol's name"
        savedAlcohol.name = NEW_ALCOHOL_NAME
        and: "saved changes"
        Alcohol updatedAlcohol = service.update(savedAlcohol.id, savedAlcohol)

        then: "updated alcohol has different name than old alcohol"
        oldAlcoholName != updatedAlcohol.name
    }

    void "Should delete exist alcohol"() {
        given: "existing alcohol in database"
        Alcohol savedAlcohol = service.getAlcohol(ALCOHOL_ID)
        and: "saved alcohol id"
        Long savedAlcoholId = savedAlcohol.id

        when: "user deleted alcohol"
        service.delete(savedAlcohol.id)
        and: "get deleted alcohol"
        service.getAlcohol(savedAlcoholId)

        then: "exception thrown"
        IllegalStateException exception = thrown()
        exception.message == "Cannot find alcohol with id = " + ALCOHOL_ID
    }
}

