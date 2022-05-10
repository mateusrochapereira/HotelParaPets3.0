package com.Tcc.HotelParaPets.Service;

import com.Tcc.HotelParaPets.Service.mapper.DonoDoPetMapper;
import com.Tcc.HotelParaPets.model.DonodoPet;
import com.Tcc.HotelParaPets.repositories.DonoDoPetRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class DonoDoPetServices {
    private final DonoDoPetRepository donodoPetRepository;


    @Transactional
    public void salvardonoDoPet(DonodoPet donodoPet) {
        donodoPetRepository.save(donodoPet);

    }

    public ResponseEntity<Void> removerDonoDoPetPorId(Integer id) {
        if (!donodoPetRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        donodoPetRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public List<DonodoPet> listarDonosDoPet() {
        return donodoPetRepository.findAll();
    }


    public ResponseEntity<DonodoPet> atualizarDonoDoPet(Integer id, DonodoPet donodoPetAtualizado) {

        //onodoPetDesatualizado vai ser o objeto que vai retornar , é diferente do donodoPetAtualizado que ta se passado em cima
        DonodoPet donodoPetDesatualizado = donodoPetRepository.findById(id).orElseThrow(RuntimeException::new); // TODO: 07/05/2022 tratar essa secao
        //copiando tudo de dentro do donodoPetAtualizado para dentro do donodoPetDesatualizado
        DonodoPet donodoPetBd = DonoDoPetMapper.convert(donodoPetAtualizado, donodoPetDesatualizado);
        donodoPetRepository.save(donodoPetBd);
        return ResponseEntity.ok().build(); // TODO: 07/05/2022 remover response entity e retornar entidade salva 
     /*
      if(!donodoPetRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        donodoPet.setId(id);
        do
        donodoPet = donodoPetRepository.save(donodoPet);
        return ResponseEntity.ok(donodoPet);*/

    }
}
