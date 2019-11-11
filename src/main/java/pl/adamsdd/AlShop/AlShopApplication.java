package pl.adamsdd.AlShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.adamsdd.AlShop.domain.alcohol.Beer;
import pl.adamsdd.AlShop.domain.alcohol.BeerType;
import pl.adamsdd.AlShop.domain.company.Company;
import pl.adamsdd.AlShop.domain.company.PreferredContactMethod;
import pl.adamsdd.AlShop.repository.alcohol.BeerRepository;
import pl.adamsdd.AlShop.repository.company.CompanyRepository;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootApplication
public class AlShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlShopApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BeerRepository repository, CompanyRepository companyRepository) {
		return args -> {
			Company company = new Company(1L, "CompanyName", "Stefan", "Eugeniusz", "Batory", "Poland", "Warsaw", "00-001", PreferredContactMethod.NUMBER, "666999333", "mail@company.pl", LocalDate.now(), LocalDate.now());
			companyRepository.save(company);

			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				Beer beer = new Beer(null, name, name, null, null, company, null, "", BeerType.AMERICAN_SOUR);
				repository.save(beer);
			});

			repository.findAll().forEach(System.out::println);
		};
	}
}
