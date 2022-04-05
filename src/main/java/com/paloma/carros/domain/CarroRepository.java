package com.paloma.carros.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarroRepository extends CrudRepository<Carro, Long> {

    List<Carro> findAllByTipo(String tipo);
}
