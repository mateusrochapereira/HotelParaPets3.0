package com.Tcc.HotelParaPets.Service;

import com.Tcc.HotelParaPets.model.DonodoPet;
import com.Tcc.HotelParaPets.model.Endereco;
import com.Tcc.HotelParaPets.repositories.DonoDoPetRepository;
import com.Tcc.HotelParaPets.repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
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

}
