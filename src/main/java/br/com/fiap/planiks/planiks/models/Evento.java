package br.com.fiap.planiks.planiks.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventoId;
    
    private String titulo;
    private String tag;
    private String categoria;
    private String comentario;
    private Long progresso;
    private Boolean estado;
    //private Prazo prazo;

    protected Evento() {
        
    }

    public Evento(Long eventoId, String titulo, String tag, String categoria, String comentario, Long progresso,
    Boolean estado) {
    this.eventoId = eventoId;
    this.titulo = titulo;
    this.tag = tag;
    this.categoria = categoria;
    this.comentario = comentario;
    this.progresso = progresso;
    this.estado = estado;
    }

    //Ver um metodo de fazer com que o prazo seja reconhecido como um JdbcType (provavelmente deve ter uma anotação pra isso)
    //Fazer ele ser lido como String e não um objeto do tipo Prazo

    // public Prazo getPrazo() {
    //     return prazo;
    // }

    // public void setPrazo(Prazo prazo) {
    //     this.prazo = prazo;
    // }

   


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

    @Override
    public String toString() {
        return "Evento [eventoId=" + eventoId + ", titulo=" + titulo + ", tag=" + tag + ", categoria=" + categoria
                + ", comentario=" + comentario + ", progresso=" + progresso + ", estado=" + estado + "]";
    }



}