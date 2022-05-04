package com.Tcc.HotelParaPets.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "increment")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login",length =20,  nullable = false)
    private String login;

    @Column(name = "senha", length =20, nullable = false)
    private String senha;


}
