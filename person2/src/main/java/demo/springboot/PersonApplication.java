package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by steve on 17-7-5.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PersonApplication {

    public static void main(String... args){
        SpringApplication.run(PersonApplication.class, args);
    }
}
