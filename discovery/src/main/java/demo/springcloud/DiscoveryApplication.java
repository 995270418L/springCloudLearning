package demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by steve on 17-7-5.
 */

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {

    public static void main(String... args){
        SpringApplication.run(DiscoveryApplication.class, args);
    }

}
