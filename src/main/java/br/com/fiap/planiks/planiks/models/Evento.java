package br.com.fiap.planiks.planiks.models;

public class Evento {
    private int eventoId;
    private String titulo;
    private String tag;
    private String categoria;
    private String comentario;
    private int progresso;
    private boolean estado;

    public Evento(int eventoId, String titulo, String tag, String categoria, String comentario, int progresso,
            boolean estado) {
        this.eventoId = eventoId;
        this.titulo = titulo;
        this.tag = tag;
        this.categoria = categoria;
        this.comentario = comentario;
        this.progresso = progresso;
        this.estado = estado;
    }
    
    public int getEventoId() {
        return eventoId;
    }
    public void setEventoId(int eventoId) {
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
    public int getProgresso() {
        return progresso;
    }
    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Evento [eventoId=" + eventoId + ", titulo=" + titulo + ", tag=" + tag + ", categoria=" + categoria
                + ", comentario=" + comentario + ", progresso=" + progresso + ", estado=" + estado + "]";
    }

    
}