package demp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by steve on 17-7-5.
 */

@RestController
public class SomeController {

    @Autowired
    HomeRemote homeRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name){
        return homeRemote.hello(name);
    }

}
