package demo.springboot;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by steve on 17-7-5.
 */

@Component
public class HelloRemoteHystrix implements HomeRemote{

    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello " + name + ", this message send failed";
    }

}
