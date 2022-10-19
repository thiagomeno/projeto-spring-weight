package br.com.menotti.springweight.controllers;

import br.com.menotti.springweight.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class InicioTest {

    @GetMapping("/ola")
    public String ola(){
        return "iniciando nossa aplicação";
    }


}
