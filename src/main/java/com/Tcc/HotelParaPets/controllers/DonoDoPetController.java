package com.Tcc.HotelParaPets.controllers;

import com.Tcc.HotelParaPets.Service.DonoDoPetServices;
import com.Tcc.HotelParaPets.Service.UserServices;
import com.Tcc.HotelParaPets.model.Cuidador;
import com.Tcc.HotelParaPets.model.DonodoPet;
import com.Tcc.HotelParaPets.model.Endereco;
import com.Tcc.HotelParaPets.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping ("/donoDoPet")
public class DonoDoPetController {
    private final DonoDoPetServices services;

    //post cripitrografa a requisicao de ibnformacoes
    @PostMapping        //manda no corpo da requisicao
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarDonoDoPet(@RequestBody DonodoPet donodoPet){

     services.salvardonoDoPet(donodoPet);
    }

}
