package tcucl.back_tcucl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BackTcuclApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackTcuclApplication.class, args);
	}

	// todo tester importation des données voyage internationale
	// + test validation des données
}
