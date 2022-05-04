package com.Tcc.HotelParaPets.repositories;


import com.Tcc.HotelParaPets.model.DonodoPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonoDoPetRepository extends JpaRepository<DonodoPet, Integer> {

}
