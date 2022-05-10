package com.Tcc.HotelParaPets.Service;

import com.Tcc.HotelParaPets.model.Pet;
import com.Tcc.HotelParaPets.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PetServices {
    private final PetRepository petRepository;

    public void salvarPet(Pet pet) {
        petRepository.save(pet);
    }

    public ResponseEntity<Void> removerPetPorId(Integer id) {
        if(!petRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
      petRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public List<Pet> listarPets() {

        return petRepository.findAll();
    }
    public ResponseEntity<Pet> atualizarPet(Integer id, Pet pet){
        if(!petRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        pet.setId(id);
        pet = petRepository.save(pet);
        return ResponseEntity.ok(pet);
    }
}
