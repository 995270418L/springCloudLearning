package demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 17-7-13.
 */

@RestController

public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<String> hello(){
        return new ArrayList<String>(){
            {
                add("a");
                add("b");
            }
        };
    }
}
