package com.Tcc.HotelParaPets.Service;

import com.Tcc.HotelParaPets.model.Telefone;
import com.Tcc.HotelParaPets.model.User;
import com.Tcc.HotelParaPets.repositories.TelefoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TelefoneServices {
    private TelefoneRepository telefoneRepository;

    public void salvarTelefone(Telefone telefone) {
        telefoneRepository.save(telefone);
    }

    public ResponseEntity<Void> removerTelefonePorId(Integer id) {
        if(!telefoneRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
       telefoneRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    public List<Telefone> listarTelefones() {

        return telefoneRepository.findAll();
    }

    public ResponseEntity<Telefone> atualizarTelefone(Integer id, Telefone telefone){
        if(!telefoneRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        telefone.setId(id);
        telefone = telefoneRepository.save(telefone);
        return ResponseEntity.ok(telefone);
    }
}
