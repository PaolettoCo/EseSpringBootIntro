package com.example.democontroller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class NameController {

    @GetMapping(path = "/{name}")
    public String name(@PathVariable("name") String name){
        return name;
    }

    @PostMapping(path = "/{name}")
    public String reverseName(@PathVariable("name") String name){
        return new StringBuilder(name).reverse().toString();
    }
}
