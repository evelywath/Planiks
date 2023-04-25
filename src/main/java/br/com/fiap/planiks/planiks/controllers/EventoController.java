package br.com.fiap.planiks.planiks.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.planiks.planiks.exception.RestNotFoundException;
import br.com.fiap.planiks.planiks.models.Evento;
import br.com.fiap.planiks.planiks.repository.EventoRepository;
import br.com.fiap.planiks.planiks.repository.PrazoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
//@RequestMapping("/api/v1/evento")
@Slf4j

public class EventoController {
    
    
    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    PrazoRepository prazoRepository;
//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/api/v1/dashboard")

        public Page<Evento> index(@RequestParam(required = false) String
        busca, @PageableDefault(size = 5) Pageable pageable) {
            
            if (busca == null) {
                return EventoRepository.findAll(pageable); 
            }
            return eventoRepository.findByEventoIdContaining(busca,
            pageable);
            
        }
    
    
//------------------------------------------------------------------------------------------------------------------
    @PostMapping("/api/v1/evento")
    public ResponseEntity<Evento> create(@RequestBody @Valid Evento evento, BindingResult result){
        log.info("Criando evento: " + evento);
        eventoRepository.save(evento);
        evento.setPrazo(prazoRepository.findById(evento.getPrazo().getPrazoId()).get());
        return ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }
//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/api/v1/evento/{eventoId}")
    public ResponseEntity<Evento> show(@PathVariable Long eventoId){
        log.info("Procurando evento: " + eventoId);
        return ResponseEntity.ok(getEvento(eventoId));
    }
//------------------------------------------------------------------------------------------------------------------
    @DeleteMapping("/api/v1/evento/{eventoId}")
    public ResponseEntity<Evento> destroy(@PathVariable Long eventoId){
        log.info("Apagando evento: " + eventoId);
        eventoRepository.delete(getEvento(eventoId));
        return ResponseEntity.noContent().build();
    }
//------------------------------------------------------------------------------------------------------------------
    @PutMapping("/api/v1/evento/{eventoId}")
    public ResponseEntity<Evento> update(@PathVariable Long eventoId, @RequestBody Evento evento){

        log.info("Atualizando evento: " + eventoId);
        getEvento(eventoId);
        evento.setEventoId(eventoId);
        eventoRepository.save(evento);
        return ResponseEntity.ok(evento);
    }
//------------------------------------------------------------------------------------------------------------------
    private Evento getEvento(Long eventoId) {
        return eventoRepository.findById(eventoId).orElseThrow(
            () -> new RestNotFoundException("Evento não encontrado"));
    }

}