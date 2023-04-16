package br.com.fiap.planiks.planiks.controllers;

import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.planiks.planiks.exception.RestNotFoundException;
import br.com.fiap.planiks.planiks.models.Prazo;
import br.com.fiap.planiks.planiks.repository.PrazoRepository;
import ch.qos.logback.classic.Logger;
import jakarta.validation.Valid;

@RestController
public class PrazoController {

    Logger log = (Logger) LoggerFactory.getLogger(EventoController.class);

    @Autowired
    PrazoRepository repository;
//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/api/v1/prazo")
    public List<Prazo> index(){
        return repository.findAll();
    }
//------------------------------------------------------------------------------------------------------------------
    @PostMapping("/api/v1/prazo")
    public ResponseEntity<Prazo> create(@RequestBody @Valid Prazo prazo, BindingResult result){
        log.info("Criando prazo: " + prazo);
        repository.save(prazo);
        return ResponseEntity.status(HttpStatus.CREATED).body(prazo);
    }
//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/api/v1/prazo/{prazoId}")
    public ResponseEntity<Prazo> show(@PathVariable Long prazoId){
        log.info("Procurando prazo: " + prazoId);
        return ResponseEntity.ok(getPrazo(prazoId));
    }
//------------------------------------------------------------------------------------------------------------------
    @PutMapping("/api/v1/prazo/{prazoId}")
    public ResponseEntity<Prazo> update(@PathVariable Long prazoId, @RequestBody Prazo prazo){

        log.info("Atualizando prazo: " + prazoId);
        getPrazo(prazoId);
        prazo.setPrazoId(prazoId);
        repository.save(prazo);
        return ResponseEntity.ok(prazo);
    }
//------------------------------------------------------------------------------------------------------------------
    private Prazo getPrazo(Long prazoId) {
        return repository.findById(prazoId).orElseThrow(
            () -> new RestNotFoundException("Prazo não encontrado"));
    }
}
