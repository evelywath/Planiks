package br.com.fiap.planiks.planiks.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.planiks.planiks.models.Evento;
import ch.qos.logback.classic.Logger;

@RestController
public class EventoController {
    

    @GetMapping("planiks/api/v1/evento/{id}")
    public Evento index(){
        return new Evento(1, "Teste","Azul", 
        "Estudos","Esse é um teste", 0,true);
    }
    

    Logger log = (Logger) LoggerFactory.getLogger(EventoController.class);

    List<Evento> evento = new ArrayList<>();

    @GetMapping("planiks/api/v1/despesas")
    public List<Evento> index1(){
        return evento;
    }


    @PostMapping("/api/v1/despesas")
    public ResponseEntity<Evento> create(@RequestBody Evento evento){
        log.info("Criando evento: " + evento);
        evento.setEventoId((int) (evento.size() + 1L));
        evento.add(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }


    @GetMapping("planiks/api/v1/despesas/{id}")
    public ResponseEntity<Evento> show(@PathVariable Long id){
        log.info("Procurando evento: " + id);
        var eventoEncontrado = evento.stream().filter(e -> e.getTitulo().equals(id)).findFirst();

        if(eventoEncontrado.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(eventoEncontrado.get());
    }


    @PutMapping("planiks/api/v1/evento/{id}")
    public ResponseEntity<Evento> update(@PathVariable int id, @RequestBody Evento evento){

        log.info("Atualizando evento: " + id);

        var eventoEncontrado = evento.stream().filter(e -> e.getId().equals(id)).findFirst();

        if(eventoEncontrado.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        evento.remove(eventoEncontrado.get());
        evento.setEventoId(id);
        evento.add(evento);

        return ResponseEntity.ok(evento);
    }


    @DeleteMapping("planiks/api/v1/evento/{id}")
    public ResponseEntity<Evento> destroy(@PathVariable Long id){
        log.info("Apagando evento: " + id);

        var eventoEncontrado = evento.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(eventoEncontrado.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        evento.remove(eventoEncontrado.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    }