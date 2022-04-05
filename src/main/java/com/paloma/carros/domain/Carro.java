package com.paloma.carros.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String tipo;

    public Carro() {
    }

    public Carro(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}

