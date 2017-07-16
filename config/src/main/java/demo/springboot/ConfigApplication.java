package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by steve on 17-7-6.
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {

    public static void main(String... args){
        SpringApplication.run(ConfigApplication.class, args);
    }
}
