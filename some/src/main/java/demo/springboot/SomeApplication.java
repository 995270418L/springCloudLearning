package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by steve on 17-7-5.
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //启用feign远程调用
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SomeApplication {

    public static void main(String... args){
        SpringApplication.run(SomeApplication.class, args);
    }

}
