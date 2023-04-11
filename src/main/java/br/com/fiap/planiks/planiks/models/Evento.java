package br.com.fiap.planiks.planiks.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    @Size(min = 5, max = 255, message = "Deve ter pelo menos 1 caractere")
    private String comentario;

    @NotNull @Min(value = 0)
    private Long progresso;

    private Boolean estado;
    //private Prazo prazo;
    
    //Por hora vamos colocar os atributos de prazo no evento
    @FutureOrPresent
    private LocalDateTime diaHora;
    
    @NotNull
    private String fuso;

    protected Evento() {
        
    }

    //Ver um metodo de fazer com que o prazo seja reconhecido como um JdbcType (provavelmente deve ter uma anotação pra isso)
    //Fazer ele ser lido como String e não um objeto do tipo Prazo

    // public Prazo getPrazo() {
    //     return prazo;
    // }

    // public void setPrazo(Prazo prazo) {
    //     this.prazo = prazo;
    // }

    public Evento(Long eventoId, String titulo, String tag, String categoria, String comentario, Long progresso,
            Boolean estado, LocalDateTime diaHora, String fuso) {
        this.eventoId = eventoId;
        this.titulo = titulo;
        this.tag = tag;
        this.categoria = categoria;
        this.comentario = comentario;
        this.progresso = progresso;
        this.estado = estado;
        this.diaHora = diaHora;
        this.fuso = fuso;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getProgresso() {
        return progresso;
    }

    public void setProgresso(Long progresso) {
        this.progresso = progresso;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(LocalDateTime diaHora) {
        this.diaHora = diaHora;
    }

    public String getFuso() {
        return fuso;
    }

    public void setFuso(String fuso) {
        this.fuso = fuso;
    }

    @Override
    public String toString() {
        return "Evento [eventoId=" + eventoId + ", titulo=" + titulo + ", tag=" + tag + ", categoria=" + categoria
                + ", comentario=" + comentario + ", progresso=" + progresso + ", estado=" + estado + ", diaHora="
                + diaHora + ", fuso=" + fuso + "]";
    }

}