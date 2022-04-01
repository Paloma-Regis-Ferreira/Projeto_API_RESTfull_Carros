package com.paloma.carros.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get(@RequestParam String nome, @RequestParam String senha){
        return "Api dos carros";
    }
}
