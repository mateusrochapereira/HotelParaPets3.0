package com.Tcc.HotelParaPets.Service.mapper;

import com.Tcc.HotelParaPets.model.*;
import lombok.experimental.UtilityClass;

//faz os metodos estaticos e construtores privados.
@UtilityClass
public class DonoDoPetMapper {
    public DonodoPet convert(DonodoPet donodoPetAtualizado, DonodoPet donodoPetDesatualizado) {
        Pet petDesatualizado = donodoPetDesatualizado.getPet();
        Pet petAtualizado = donodoPetAtualizado.getPet();
        Endereco enderecoAtualizado = donodoPetAtualizado.getEndereco();
        Endereco endereDesatualizado = donodoPetDesatualizado.getEndereco();
        Telefone telefoneAtualizado = donodoPetAtualizado.getTelefone();
        Telefone telefoneDesatualizado = donodoPetDesatualizado.getTelefone();
        User userAtualizado = donodoPetAtualizado.getUser();
        User userDesatualizado = donodoPetDesatualizado.getUser();

        return DonodoPet.builder()
                .id(donodoPetDesatualizado.getId())
                .nome(donodoPetAtualizado.getNome())
                .cpf(donodoPetAtualizado.getCpf())
                .pet(getPet(petDesatualizado.getId(), petAtualizado))
                .endereco(getEndereco(endereDesatualizado.getId(), enderecoAtualizado))
                .telefone(getTelefone(telefoneDesatualizado.getId(), telefoneAtualizado))
                .user(getUser(userDesatualizado.getId(), userAtualizado))
                .build();
    }

    private User getUser(Integer id, User userAtualizado) {
        return User.builder()
                .id(id)
                .login(userAtualizado.getLogin())
                .senha(userAtualizado.getSenha())
                .build();
    }

    private Telefone getTelefone(Integer id, Telefone telefoneAtualizado) {
        return Telefone.builder()
                .id(id)
                .ddd(telefoneAtualizado.getDdd())
                .numero(telefoneAtualizado.getNumero())
                .build();
    }

    private Endereco getEndereco(Integer id, Endereco enderecoAtualizado) {
        return Endereco.builder()
                .id(id)
                .quadra(enderecoAtualizado.getQuadra())
                .alameda(enderecoAtualizado.getAlameda())
                .lote(enderecoAtualizado.getLote())
                .bairro(enderecoAtualizado.getBairro())
                .build();

    }

    private Pet getPet(Integer id, Pet petAtualizado) {
        return Pet.builder()
                .id(id)
                .tipo(petAtualizado.getTipo())
                .tamanho(petAtualizado.getTamanho())
                .peso(petAtualizado.getPeso())
                .raca(petAtualizado.getRaca())
                .build();
    }
}
