package br.com.fiap.planiks.planiks.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.planiks.planiks.models.Evento;

@RestController
public class DashboardController {
    
    List<Evento> ListaEvento = new ArrayList<>();

    @GetMapping("/api/v1/dashboard")
    public List<Evento> index(){
        return ListaEvento;
    }
}
