package com.Tcc.HotelParaPets.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "dono")
public class DonodoPet  {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "increment")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name= "nome")
    private String nome;

    @Column(name= "cpf")
    private String cpf;

//para caso nao existir o  usuario é criado por persistencia
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "id_usuario")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "id_pet")
    private Pet pet;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "id_endereco")
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "id_telefone")
    private Telefone telefone;


}
