package com.Tcc.HotelParaPets.Service;

import com.Tcc.HotelParaPets.model.Endereco;
import com.Tcc.HotelParaPets.model.Telefone;
import com.Tcc.HotelParaPets.repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoServices {
    private EnderecoRepository enderecoRepository;

    public void salvarEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public ResponseEntity<Void> removerEndereco(Integer id) {
        if(!enderecoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        enderecoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public List<Endereco> listarEnderecos() {

        return enderecoRepository.findAll();
    }

    public ResponseEntity<Endereco> atualizarEndereco(Integer id, Endereco endereco){
        if(!enderecoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        endereco.setId(id);
        endereco = enderecoRepository.save(endereco);
        return ResponseEntity.ok(endereco);
    }
}
