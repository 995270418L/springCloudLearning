package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by steve on 17-7-6.
 */

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigRegisterApplication {

    public static void main(String... args){
        SpringApplication.run(ConfigRegisterApplication.class, args);
    }
}
