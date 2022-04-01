package com.paloma.carros.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String helloget(){
        return "get spring boot";
    }

    @PostMapping
    public String hellopost(){
        return "post spring boot";
    }

    @PutMapping
    public String helloput(){
        return "put spring boot";
    }

    @DeleteMapping
    public String hellodelete(){
        return "delete spring boot";
    }
}
