package demo.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by steve on 17-7-5.
 */

@RestController
public class HomeController {

    @RequestMapping("/hello2")
    public String index(@RequestParam String name){
        return "hello " + name + "this is the person2 module send you message";
    }
}
