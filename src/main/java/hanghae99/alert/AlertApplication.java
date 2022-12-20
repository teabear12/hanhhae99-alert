package hanghae99.alert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AlertApplication {
	public static void main(String[] args) {
		SpringApplication.run(AlertApplication.class, args);
	}
}