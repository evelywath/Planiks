package br.com.fiap.planiks.planiks.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.fiap.planiks.planiks.models.Evento;

public class EventoController {

   //@PostMapping("planiks/api/v1/evento")

    @GetMapping("planiks/api/v1/evento/{id}")
    public Evento index(){
        return new Evento(1, "Teste","Azul", 
        "Estudos","Esse é um teste", 0,true);
    }

    //@PutMapping("planiks/api/v1/evento/{id}")

    //@DeleteMapping("planiks/api/v1/evento/{id}")

}