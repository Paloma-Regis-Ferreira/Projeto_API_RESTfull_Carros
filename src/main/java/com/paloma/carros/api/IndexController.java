package com.paloma.carros.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String getExemplo1(@RequestParam String nome, @RequestParam String senha){
        //http://localhost:8080/?nome=paloma&senha=123
        //primeiro parametro é iniciado com ? e os demais com &
        return "nome: " + nome + ", senha: " + senha;
    }

    @GetMapping("/login/{nome}/{senha}")
    public String getExemplo2(@PathVariable String nome, @PathVariable String senha){
        //http://localhost:8080/login/paloma/123
        return "Nome: " + nome +", senha: " + senha;
    }

}
