package com.Tcc.HotelParaPets.controllers;

import com.Tcc.HotelParaPets.Service.DonoDoPetServices;
import com.Tcc.HotelParaPets.model.DonodoPet;
import com.Tcc.HotelParaPets.model.exception.DonoDoPetNaoEncontradoException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/donoDoPet")
public class DonoDoPetController {
    private final DonoDoPetServices services;

    //post cripitrografa a requisicao de ibnformacoes
    @PostMapping        //manda no corpo da requisicao
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarDonoDoPet(@RequestBody DonodoPet donodoPet) {

        services.salvardonoDoPet(donodoPet);
    }

    @DeleteMapping("/removerDonoDoPet/{id}")
    public ResponseEntity<Void> removeUsuario(@PathVariable Integer id) {
        return services.removerDonoDoPetPorId(id);
    }

    @GetMapping("donosDoPet")
    public List<DonodoPet> listarDonosDoPet() {
        return services.listarDonosDoPet();
    }

    @PutMapping("atualizacaoDonoDoPet/{id}")
    public ResponseEntity<DonodoPet> atualizarDonoDoPetPorID(@PathVariable int id, @RequestBody DonodoPet donodoPet) {
        try {//tudo que esta dentro das chaves ja tentar ser executado
            DonodoPet donoDoPetAtualizado = services.atualizarDonoDoPet(id, donodoPet);
            return ResponseEntity.ok(donoDoPetAtualizado);
        } catch (DonoDoPetNaoEncontradoException e) {
            log.error("[45] - DonoDoPet com id:" + id + " não encontrado");
            return ResponseEntity.notFound().build();
        }
    }
}
