package com.Tcc.HotelParaPets.model;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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
