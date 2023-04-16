package br.com.fiap.planiks.planiks.models;

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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
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

    @NotBlank @Size(min = 5, max = 255, message = "Deve ter pelo menos 1 caractere")
    private String comentario;

    @NotNull @Min(value = 0)
    private Long progresso;

    private Boolean estado;

    @ManyToOne
    private Prazo prazo;

}