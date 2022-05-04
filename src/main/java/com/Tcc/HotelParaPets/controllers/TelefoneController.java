package com.Tcc.HotelParaPets.controllers;

import com.Tcc.HotelParaPets.Service.TelefoneServices;
import com.Tcc.HotelParaPets.model.Telefone;
import com.Tcc.HotelParaPets.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    final TelefoneServices telefoneServices;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarTelefone(@RequestBody Telefone telefone){
        telefoneServices.salvarTelefone(telefone);
    }

    @DeleteMapping("/removerTelefone/{id}")
    public ResponseEntity<Void> removeUsuario(@PathVariable Integer id){
        return telefoneServices.removerTelefonePorId(id);
    }
    @GetMapping("/telefones")
    public List<Telefone> listarTelefones(){
        return telefoneServices.listarTelefones();
    }

    @PutMapping("atualizacao/{id}")
    public ResponseEntity<Telefone> atualizarTelefoneID(@PathVariable  int id, @RequestBody Telefone telefone){
        return telefoneServices.atualizarTelefone(id, telefone);
    }

}
