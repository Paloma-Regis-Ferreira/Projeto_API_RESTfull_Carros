package com.paloma.carros.api;

import com.paloma.carros.domain.Carro;
import com.paloma.carros.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService service;

    @GetMapping
    public Iterable<Carro> findAll(){
        return service.getCarros();
    }

    @GetMapping("/{id}")
    public Optional<Carro> findById(@PathVariable("id") Long id){
        return service.getCarroById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public Iterable<Carro> findByTipo(@PathVariable("tipo") String tipo){
        return service.getCarroByTipo(tipo);
    }
}
