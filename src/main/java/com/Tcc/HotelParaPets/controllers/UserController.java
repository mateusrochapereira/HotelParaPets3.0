package com.Tcc.HotelParaPets.controllers;

import com.Tcc.HotelParaPets.Service.UserServices;
import com.Tcc.HotelParaPets.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//construtor lombok com atributos do final
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserServices services;

    @GetMapping("/nome/{id}")
                                    //manda no caminho da requisicao
    public String buscarNomeUsuario(@PathVariable Integer id) {
        return services. buscarNomePorId(id);
    }

    //post cripitrografa a requisicao de ibnformacoes
    @PostMapping        //manda no corpo da requisicao
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarUsuario(@RequestBody User user){
        services.salvarUsuario(user);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removeUsuario(@PathVariable Integer id){
       return services.removerUsuarioPorId(id);
    }

    @GetMapping("/usuarios")
    public List<User> listarUsuarios() {
        return services.listarUsuarios();
        //services.listarUsuarios();
    }
    @PutMapping("atualizacao/{id}")
    public ResponseEntity<User> atualizarClienteporID(@PathVariable  int id, @RequestBody User user){
       return services.atualizar(id,user);
    }
}
