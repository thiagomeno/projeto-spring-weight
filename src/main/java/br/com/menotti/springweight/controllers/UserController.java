package br.com.menotti.springweight.controllers;

import br.com.menotti.springweight.model.User;
import br.com.menotti.springweight.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})// forma de colocar mais de uma chamada
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @GetMapping
    public Iterable<User> queryUserAll(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/name/{splitName}")
    public Iterable<User> queryUserSplitName(@PathVariable String splitName){
        return userRepository.findByNameContainingIgnoreCase(splitName);
    }

    @GetMapping(path = "/{id}")
    public Optional<User> queryUserId(@PathVariable int id){
        return userRepository.findById(id);
    }

    @GetMapping(path = "/page_user/{pagenumber}/{qtdpagina}")
    public Iterable<User> userForPage(@PathVariable int pagenumber, int qtdpagina){
        if(qtdpagina >= 5) qtdpagina = 5;
        Pageable page = PageRequest.of(pagenumber,qtdpagina);
        return userRepository.findAll(page);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Usuário excluído com sucesso.";
        }else {
            return "Usuário não encontrado.";
        }



    }

//    @PutMapping
//    public User alterUser(User user){
//        return userRepository.save(user);
//    }

}
