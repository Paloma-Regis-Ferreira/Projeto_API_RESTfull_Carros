package com.paloma.carros.api;

import com.paloma.carros.domain.Carro;
import com.paloma.carros.domain.CarroService;
import com.paloma.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<CarroDTO>> findAll(){
        return ResponseEntity.ok(service.getCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Optional<CarroDTO> carro = service.getCarroById(id);
        return carro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

        //mesma coisa que:
        // carro.isPresent()? ResponseEntity.ok(carro.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity findByTipo(@PathVariable("tipo") String tipo){
        List<CarroDTO> carros = service.getCarroByTipo(tipo);
        return carros.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(carros);
    }

    @PostMapping
    public String postCarro(@RequestBody Carro carro){
        Carro carroSalvo = service.save(carro);
        return "Carro salvo: " + carroSalvo.getNome() +", id: " + carroSalvo.getId();
    }

    @PutMapping("/{id}")
    public String updateCarro(@PathVariable("id") Long id, @RequestBody Carro carro){
        CarroDTO carroAtualizado = service.update(carro, id);
        return "Carro salvo: " + carroAtualizado.getNome() +", id: " + carroAtualizado.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "Carro " + id + " deletado";
    }

}
