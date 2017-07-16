package demo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目运行后访问 http://localhost:8080/swagger-ui.html
 */

@SpringBootApplication
public class Swagger2Application {
	private static Logger logger = LoggerFactory.getLogger(Swagger2Application.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Swagger2Application.class);
		app.setDefaultProperties((Map<String, Object>) new HashMap<String, Object>().put("spring.profiles.active", "dev"));
		output(app.run(args).getEnvironment());
	}

	private static void output(ConfigurableEnvironment environment) {
		environment.getActiveProfiles();
		logger.info("\t\nSwagger application {} is running now! \n\t Access url: http://127.0.0.1:{}\n\t Active profile: {}\n", environment.getProperty("spring.application.name"),environment.getProperty("server.port"),environment.getActiveProfiles());
	}
}
