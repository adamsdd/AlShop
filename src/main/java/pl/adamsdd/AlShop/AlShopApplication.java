package pl.adamsdd.AlShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.adamsdd.AlShop.domain.alcohol.Beer;
import pl.adamsdd.AlShop.domain.alcohol.BeerType;
import pl.adamsdd.AlShop.repository.alcohol.BeerRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class AlShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlShopApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BeerRepository repository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				Beer beer = new Beer(null, name, name, null, null, null, null, new byte[0], BeerType.LAGER);
				repository.save(beer);
			});

			repository.findAll().forEach(System.out::println);
		};
	}
}
