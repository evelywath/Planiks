package br.com.fiap.planiks.planiks.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.fiap.planiks.planiks.models.Prazo;

public class PrazoController {

    //@PostMapping("planiks/api/v1/prazo")

    @GetMapping("planiks/api/v1/prazo/{id}")
    public Prazo index(){
        return new Prazo(null, null, null, null, null);
    }


    @GetMapping("planiks/api/v1/prazo/{id}")
    public Prazo index1(){
        return new Prazo(null, null, null, null, null);
    }

    // Pesquisar como inserir dado tipo LocalDate corretamente

    //@PutMapping("planiks/api/v1/prazo/{id}")

    //@DeleteMapping("planiks/api/v1/prazo/{id}")
}