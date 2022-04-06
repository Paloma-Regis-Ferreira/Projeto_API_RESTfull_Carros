package com.paloma.carros.domain;

import com.paloma.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public List<CarroDTO> getCarros(){
        return repository.findAll().stream().map(CarroDTO::new).collect(Collectors.toList());
    }

    public Optional<CarroDTO> getCarroById(Long id) {
        return repository.findById(id).map(CarroDTO::new);
    }

    public List<Carro> getCarrosMock(){
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L, "Fusca"));
        carros.add(new Carro(2L, "Moto"));
        carros.add(new Carro(3L, "Carroça"));

        return carros;
    }

    public List<CarroDTO> getCarroByTipo(String tipo) {
        return repository.findAllByTipo(tipo).stream().map(CarroDTO::new).collect(Collectors.toList());
    }

    public Carro save(Carro carro) {
        return repository.save(carro);
    }

    public CarroDTO update(Carro carro, Long id) {
        Assert.notNull(id, "nao foi possivel encontrar o carro por esse id");

        Optional<Carro> tratandoOptional = repository.findById(id);
        if(tratandoOptional.isPresent()){
            Carro carroDoBanco = tratandoOptional.get();
            carroDoBanco.setNome(carro.getNome());
            carroDoBanco.setTipo(carro.getTipo());

            repository.save(carroDoBanco);

            System.out.println("Carro id: " + carroDoBanco.getId() + " foi atualizado");
            return new CarroDTO(carroDoBanco);
        }else{
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }

    }

    public void delete(Long id) {
        if(getCarroById(id).isPresent())
            repository.deleteById(id);
    }
}
