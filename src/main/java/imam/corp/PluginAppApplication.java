package imam.corp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PluginAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluginAppApplication.class, args);
	}

}
