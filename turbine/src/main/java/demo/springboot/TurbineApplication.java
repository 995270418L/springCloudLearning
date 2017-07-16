package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by steve on 17-7-6.
 */

@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine  //激活对Turbine的支持
public class TurbineApplication {

    public static void main(String... args){
        SpringApplication.run(TurbineApplication.class, args);
    }

}
