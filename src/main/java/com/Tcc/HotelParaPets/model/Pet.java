package com.Tcc.HotelParaPets.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "pet")

public class Pet {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "increment")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "tamanho", nullable = false)
    private float tamanho;

    @Column(name = "peso", nullable = false)
    private float peso;

    @Column(name = "raca", nullable = false)
    private String raca;


}
