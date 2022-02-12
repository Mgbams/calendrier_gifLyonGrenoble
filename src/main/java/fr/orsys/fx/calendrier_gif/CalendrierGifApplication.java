package fr.orsys.fx.calendrier_gif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CalendrierGifApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendrierGifApplication.class, args);
	}

}
