package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by steve on 17-7-5.
 */

@SpringBootApplication

// 开启这个注解，就有了服务注册的功能
@EnableDiscoveryClient
public class PersonApplication {

    public static void main(String... args){
        SpringApplication.run(PersonApplication.class, args);
    }

}
