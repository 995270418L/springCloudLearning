package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by steve on 17-7-10.
 */

@SpringBootApplication
public class RedisDemoApplication {

    public static void main(String... args){
        SpringApplication.run(RedisDemoApplication.class, args);
    }
}
