package com.Tcc.HotelParaPets.Service;

import com.Tcc.HotelParaPets.model.User;
import com.Tcc.HotelParaPets.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@AllArgsConstructor
@Service
public class UserServices {
    //allargscontructor substituiu o antigo cosntrutor
    final UserRepository userRepository;


     @PersistenceContext
    private EntityManager manager;


    //construtor do repository



    public String buscarNomePorId(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return user.getLogin();
    }


    public void salvarUsuario(User user) {
        userRepository.save(user);
    }

    public ResponseEntity<Void> removerUsuarioPorId(Integer id) {
        if(!userRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public List<User>  listarUsuarios() {

        return userRepository.findAll();
    }


    public ResponseEntity<User> atualizar(Integer id, User user){
            if(!userRepository.existsById(id)){
                return ResponseEntity.notFound().build();
            }
            user.setId(id);
             user = userRepository.save(user);
            return ResponseEntity.ok(user);
    }

}

