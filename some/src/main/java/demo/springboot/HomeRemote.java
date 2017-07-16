package demo.springboot;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by steve on 17-7-5.
 */
// hystrix融断机制一般在服务调用者这边使用
@FeignClient(name = "person", fallback = HelloRemoteHystrix.class) //值默认不是赋给 name(别名) 属性 调用person服务提供者的服务
public interface HomeRemote {

    @RequestMapping("/hello")
    String hello(@RequestParam(value = "name") String name);

}
