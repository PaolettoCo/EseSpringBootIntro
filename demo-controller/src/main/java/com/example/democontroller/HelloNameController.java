package com.example.democontroller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloNameController {
    @GetMapping(path = "/v1/ciao")
    public String helloName(@RequestParam String name, @RequestParam String province){
        return "ciao " + name + ", com'è il tempo in " + province + "?";
    }

    @GetMapping(path = "/v2/ciao/{province}")
    public Person returnJson(
            @PathVariable String province,
            @RequestParam String name
    ){
        return new Person(name, province);
    }

}
