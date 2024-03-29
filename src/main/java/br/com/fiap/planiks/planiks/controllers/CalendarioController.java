package br.com.fiap.planiks.planiks.controllers;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.planiks.planiks.models.Calendario;

@RestController
public class CalendarioController {
    
    @GetMapping("/api/v1/calendario")
    public Calendario index(){
        return new Calendario(Calendar.getInstance());
    }
}
