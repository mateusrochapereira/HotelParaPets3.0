package com.Tcc.HotelParaPets.repositories;

import com.Tcc.HotelParaPets.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository  extends JpaRepository<Pet, Integer > {
}
