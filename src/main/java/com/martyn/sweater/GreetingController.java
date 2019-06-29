package com.martyn.sweater;
//https://spring.io/guides/gs/serving-web-content/
//https://www.youtube.com/watch?v=jH17YkBTpI4&list=PLU2ftbIeotGoGSEUf54LQH-DgiQPF2XRO
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String,Object> model) {
        model.put("name", name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String, Object> model){
        model.put("some","Lets code!");
        return "main";
    }
}

/*
The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
@RequestParam binds the value of the query String parameter name into the name parameter of the greeting() method.
This query String parameter is not required; if it is absent in the request, the defaultValue of "World" is used.
The value of the name parameter is added to a Model object, ultimately making it accessible to the view template.
 */
