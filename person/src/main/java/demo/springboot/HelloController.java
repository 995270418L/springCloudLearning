package demo.springboot;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by steve on 17-7-5.
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(@RequestParam String name){
        return "Hello "+name+", this is first message";
    }

    @RequestMapping("/")
    public String hello(){
        return "This is the first person module";
    }

}
