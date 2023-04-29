package br.com.fiap.planiks.planiks.models;

import org.springframework.hateoas.EntityModel;
import org.springframework.data.domain.Pageable;

import br.com.fiap.planiks.planiks.controllers.EventoController;
import br.com.fiap.planiks.planiks.controllers.PrazoController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventoId;
    
    @NotBlank
    private String titulo;

    @NotBlank
    private String tag;

    @NotBlank
    private String categoria;

    @NotBlank @Size(min = 5, max = 255, message = "Deve ter pelo menos 1 caractére")
    private String comentario;

    @NotNull @Min(value = 0)
    private Long progresso;

    private Boolean estado;

    @ManyToOne
    private Prazo prazo;

    public EntityModel<Evento> toEntityModel() {

        return EntityModel.of(
            this,
            
            linkTo(methodOn(EventoController.class).show(eventoId)).withSelfRel(),
            linkTo(methodOn(EventoController.class).destroy(eventoId)).withRel("delete"),
                    linkTo(methodOn(EventoController.class).index(null, Pageable.unpaged())).withRel("all"),

            linkTo(methodOn(PrazoController.class).show(this.getPrazo().getPrazoId())).withRel("prazo")

            );

    }

}