package br.com.fiap.planiks.planiks.controllers;

import org.springdoc.core.annotations.ParameterObject;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.planiks.planiks.exception.RestNotFoundException;
import br.com.fiap.planiks.planiks.models.Evento;
import br.com.fiap.planiks.planiks.repository.EventoRepository;
import br.com.fiap.planiks.planiks.repository.PrazoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/evento")
@Slf4j
@SecurityRequirement(name = "bearer-key")
@Tag(name = "despesa")

public class EventoController {

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    PrazoRepository prazoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/api/v1/dashboard")
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
            var evento = (busca == null) ?
                EventoRepository.findAll(pageable):
                eventoRepository.findByEventoIdContaining(busca, (org.springframework.data.domain.Pageable) pageable);

                return assembler.toModel((((Page<Evento>) evento).map(Evento::toEntityModel)));

        }
    
//------------------------------------------------------------------------------------------------------------------
    @PostMapping("/api/v1/evento")

    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Evento criado com sucesso!"),
        @ApiResponse(responseCode = "400", description = "Descrição válida para criação do evento.")
    })
    public ResponseEntity<EntityModel<Evento>> create(
        @RequestBody @Valid Evento evento, BindingResult result){
        log.info("Criando evento: " + evento);
        eventoRepository.save(evento);

        evento.setPrazo(prazoRepository.findById(evento.getPrazo().getPrazoId()).get());
        return ResponseEntity

        .created(evento.toEntityModel().getRequiredLink("self").toUri())
        .body(evento.toEntityModel());

    }
//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/api/v1/evento/{eventoId}")
    @Operation(
        summary = "Detalhes do evento",
        description = "Retornar os dados do evento de acordo com o id informado no path"
    )
    public EntityModel<Evento> show(@PathVariable Long eventoId){
        log.info("Procurando evento: " + eventoId);
        return getEvento(eventoId).toEntityModel();
    }
//------------------------------------------------------------------------------------------------------------------
    @DeleteMapping("/api/v1/evento/{eventoId}")
    public EntityModel<Evento> destroy(@PathVariable Long eventoId){
        log.info("Apagando evento: " + eventoId);
        eventoRepository.delete(getEvento(eventoId));
        return getEvento(eventoId).toEntityModel();
    }
//------------------------------------------------------------------------------------------------------------------
    @PutMapping("/api/v1/evento/{eventoId}")
    public ResponseEntity<EntityModel<Evento>>update(
        @PathVariable Long eventoId, @RequestBody Evento evento){
        log.info("Atualizando evento: " + eventoId);
        getEvento(eventoId);
        evento.setEventoId(eventoId);
        eventoRepository.save(evento);
        return ResponseEntity.ok(evento.toEntityModel());
    }
//------------------------------------------------------------------------------------------------------------------
    private Evento getEvento(Long eventoId) {
        return eventoRepository.findById(eventoId).orElseThrow(
            () -> new RestNotFoundException("Evento não encontrado"));
    }

}