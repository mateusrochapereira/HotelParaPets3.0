package com.Tcc.HotelParaPets.repositories;

import com.Tcc.HotelParaPets.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Integer> {
}
