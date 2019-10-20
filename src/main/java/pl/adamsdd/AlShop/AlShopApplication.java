package pl.adamsdd.AlShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.adamsdd.AlShop.domain.alcohol.Alcohol;
import pl.adamsdd.AlShop.repository.AlcoholRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class AlShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlShopApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AlcoholRepository repository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				Alcohol user = new Alcohol(null, name, name, new byte[0]);
				repository.save(user);
			});

			repository.findAll().forEach(System.out::println);
		};
	}
}
