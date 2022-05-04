package com.Tcc.HotelParaPets.controllers;

import com.Tcc.HotelParaPets.Service.EnderecoServices;
import com.Tcc.HotelParaPets.Service.TelefoneServices;
import com.Tcc.HotelParaPets.model.Endereco;
import com.Tcc.HotelParaPets.model.Telefone;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    final EnderecoServices enderecoServices;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarEndereco(@RequestBody Endereco endereco){
        enderecoServices.salvarEndereco(endereco);
    }

    @DeleteMapping("/removerEndereco/{id}")
    public ResponseEntity<Void> removerEnderecoPorId(@PathVariable Integer id){
        return enderecoServices.removerEndereco(id);
    }

    @GetMapping("/enderecos")
    public List<Endereco> listarEnderecos(){
        return enderecoServices.listarEnderecos();
    }

    @PutMapping("atualizacao/{id}")
    public ResponseEntity<Endereco> atualizarEnderecoporID(@PathVariable  int id, @RequestBody Endereco endereco){
        return enderecoServices.atualizarEndereco(id, endereco);
    }
}
