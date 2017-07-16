package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by steve on 17-7-6.
 */

@EnableZuulProxy
@SpringBootApplication
@EnableFeignClients
public class ZuulApplication {

    public static void main(String... args){
        SpringApplication.run(ZuulApplication.class, args);
    }

}
