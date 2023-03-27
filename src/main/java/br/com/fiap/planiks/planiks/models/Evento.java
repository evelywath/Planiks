package br.com.fiap.planiks.planiks.models;

public class Evento {

    private Long eventoId;
    private String titulo;
    private String tag;
    private String categoria;
    private String comentario;
    private Long progresso;
    private Boolean estado;
    private Prazo prazo;

    public Prazo getPrazo() {
        return prazo;
    }

    public void setPrazo(Prazo prazo) {
        this.prazo = prazo;
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

    @Override
    public String toString() {
        return "Evento [eventoId=" + eventoId + ", titulo=" + titulo + ", tag=" + tag + ", categoria=" + categoria
                + ", comentario=" + comentario + ", progresso=" + progresso + ", estado=" + estado + ", prazo=" + prazo
                + "]";
    }



}