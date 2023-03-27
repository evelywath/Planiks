package br.com.fiap.planiks.planiks.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
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
    
    Logger log = (Logger) LoggerFactory.getLogger(EventoController.class);

    List<Evento> ListaEvento = new ArrayList<>();

//------------------------------------------------------------------------------------------------------------------
    @PostMapping("/api/v1/evento")
    public ResponseEntity<Evento> create(@RequestBody Evento evento){
        log.info("Criando evento: " + evento);
        evento.setEventoId((Long) (ListaEvento.size() + 1L));
        ListaEvento.add(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }
//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/api/v1/evento/{id}")
    public ResponseEntity<Evento> show(@PathVariable Long eventoId){
        log.info("Procurando evento: " + eventoId);
        var eventoEncontrado = ListaEvento.stream().filter(e -> e.getTitulo().equals(eventoId)).findFirst();

        if(eventoEncontrado.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(eventoEncontrado.get());
    }
//------------------------------------------------------------------------------------------------------------------
    @DeleteMapping("/api/v1/evento/{id}")
    public ResponseEntity<Evento> destroy(@PathVariable Long eventoId){
        log.info("Apagando evento: " + eventoId);

        var eventoEncontrado = ListaEvento.stream().filter(d -> d.getEventoId().equals(eventoId)).findFirst();

        if(eventoEncontrado.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        ListaEvento.remove(eventoEncontrado.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
//------------------------------------------------------------------------------------------------------------------
    @PutMapping("/api/v1/evento/{id}")
    public ResponseEntity<Evento> update(@PathVariable Long eventoId, @RequestBody Evento evento){

        log.info("Atualizando evento: " + eventoId);

        var eventoEncontrado = ListaEvento.stream().filter(e -> e.getEventoId().equals(eventoId)).findFirst();

        if(eventoEncontrado.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        ListaEvento.remove(eventoEncontrado.get());
        evento.setEventoId(eventoId);
        ListaEvento.add(evento);

        return ResponseEntity.ok(evento);
    }
    }