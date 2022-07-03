package pl.pjwstk.jazs23047nbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JazS23047NbpApplication {

	@Bean
	public RestTemplate restTemplate() {return new RestTemplate();}

	public static void main(String[] args) {
		SpringApplication.run(JazS23047NbpApplication.class, args);
	}

}
