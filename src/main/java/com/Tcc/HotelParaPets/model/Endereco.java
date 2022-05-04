package com.Tcc.HotelParaPets.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "increment")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "quadra", nullable = false)
    private String quadra;

    @Column(name = "alameda", nullable = false)
    private String alameda;

    @Column(name = "lote", nullable = false)
    private String lote;

    @Column(name = "bairro", nullable = false)
    private String bairro;


}
