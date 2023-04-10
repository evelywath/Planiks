package br.com.fiap.planiks.planiks.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.planiks.planiks.exception.RestNotFoundException;
import br.com.fiap.planiks.planiks.models.Evento;
import br.com.fiap.planiks.planiks.repository.EventoRepository;
import ch.qos.logback.classic.Logger;
import jakarta.validation.Valid;


@RestController
//@RequestMapping("/api/v1/evento")
public class EventoController {
    
    Logger log = (Logger) LoggerFactory.getLogger(EventoController.class);

    @Autowired
    EventoRepository repository;
//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/api/v1/dashboard")
    public List<Evento> index(){
        return repository.findAll();
    }
//------------------------------------------------------------------------------------------------------------------
    @PostMapping("/api/v1/evento")
    public ResponseEntity<Evento> create(@RequestBody @Valid Evento evento, BindingResult result){
        log.info("Criando evento: " + evento);
        repository.save(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }
//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/api/v1/evento/{id}")
    public ResponseEntity<Evento> show(@PathVariable Long eventoId){
        log.info("Procurando evento: " + eventoId);
        return ResponseEntity.ok(getEvento(eventoId));
    }
//------------------------------------------------------------------------------------------------------------------
    @DeleteMapping("/api/v1/evento/{id}")
    public ResponseEntity<Evento> destroy(@PathVariable Long eventoId){
        log.info("Apagando evento: " + eventoId);
        repository.delete(getEvento(eventoId));
        return ResponseEntity.noContent().build();
    }
//------------------------------------------------------------------------------------------------------------------
    @PutMapping("/api/v1/evento/{id}")
    public ResponseEntity<Evento> update(@PathVariable Long eventoId, @RequestBody Evento evento){

        log.info("Atualizando evento: " + eventoId);
        getEvento(eventoId);
        evento.setEventoId(eventoId);
        repository.save(evento);
        return ResponseEntity.ok(evento);
    }
//------------------------------------------------------------------------------------------------------------------
    private Evento getEvento(Long eventoId) {
        return repository.findById(eventoId).orElseThrow(
            () -> new RestNotFoundException("Evento não encontrado"));
    }

}