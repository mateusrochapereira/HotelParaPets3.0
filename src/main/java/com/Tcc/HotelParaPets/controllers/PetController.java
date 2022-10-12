package com.Tcc.HotelParaPets.controllers;


import com.Tcc.HotelParaPets.Service.PetServices;
import com.Tcc.HotelParaPets.model.Pet;

import com.Tcc.HotelParaPets.model.Telefone;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pet")
public class PetController {

    final PetServices petServices;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarPet(@RequestBody Pet pet){petServices.salvarPet(pet);}

    @DeleteMapping("/removerPet/{id}")
    public ResponseEntity<Void> removerPet(@PathVariable Integer id){
        return petServices.removerPetPorId(id);
    }
    @GetMapping("/pets")
    public List<Pet> listarPet(){
        return petServices.listarPets();
    }
    @PutMapping("atualizacao/{id}")
    public ResponseEntity<Pet> atualizarPetporID(@PathVariable  int id, @RequestBody Pet pet){
        return petServices.atualizarPet(id, pet);
    }
}
