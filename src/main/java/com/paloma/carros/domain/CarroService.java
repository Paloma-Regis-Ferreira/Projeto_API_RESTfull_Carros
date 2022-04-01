package com.paloma.carros.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public Iterable<Carro> getCarros(){
        return repository.findAll();
    }

    public Optional<Carro> getCarroById(Long id) {
        return repository.findById(id);
    }

    public List<Carro> getCarrosMock(){
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L, "Fusca"));
        carros.add(new Carro(2L, "Moto"));
        carros.add(new Carro(3L, "Carroça"));

        return carros;
    }

    public Iterable<Carro> getCarroByTipo(String tipo) {
        return repository.findAllByTipo(tipo);
    }

    public Carro save(Carro carro) {
        return repository.save(carro);
    }

    public Carro update(Carro carro, Long id) {
        Assert.notNull(id, "nao foi possivel encontrar o carro por esse id");

        Optional<Carro> tratandoOptional = getCarroById(id);
        if(tratandoOptional.isPresent()){
            Carro carroDoBanco = tratandoOptional.get();
            carroDoBanco.setNome(carro.getNome());
            carroDoBanco.setTipo(carro.getTipo());

            repository.save(carroDoBanco);

            System.out.println("Carro id: " + carroDoBanco.getId() + " foi atualizado");
            return carroDoBanco;
        }else{
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }

    }

    public void delete(Long id) {
        Optional<Carro> carro = getCarroById(id);
        if(carro.isPresent())
            repository.deleteById(id);
    }
}
