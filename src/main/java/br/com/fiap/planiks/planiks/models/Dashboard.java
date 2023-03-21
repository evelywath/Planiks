package br.com.fiap.planiks.planiks.models;

import java.util.List;

public class Dashboard {
    
    private List todo;
    private List projetos;
    private List eventos;

    public Dashboard(List todo, List projetos, List eventos) {
        this.todo = todo;
        this.projetos = projetos;
        this.eventos = eventos;
    }
    
    public List getTodo() {
        return todo;
    }
    public void setTodo(List todo) {
        this.todo = todo;
    }
    public List getProjetos() {
        return projetos;
    }
    public void setProjetos(List projetos) {
        this.projetos = projetos;
    }
    public List getEventos() {
        return eventos;
    }
    public void setEventos(List eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return "Dashboard [todo=" + todo + ", projetos=" + projetos + ", eventos=" + eventos + "]";
    }

    
}
