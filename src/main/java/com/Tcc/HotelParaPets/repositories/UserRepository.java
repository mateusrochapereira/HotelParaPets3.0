package com.Tcc.HotelParaPets.repositories;

import com.Tcc.HotelParaPets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("select u from User u where u.id = ?1")
    @Override
    Optional<User> findById(Integer integer);

}
