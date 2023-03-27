package br.com.fiap.planiks.planiks.models;

import java.util.Calendar;

public class Calendario {
    
    private Calendar calendario;

    public Calendario(Calendar calendario) {
        this.calendario = calendario;
    }

    public Calendar getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }

    @Override
    public String toString() {
        return "Calendario [calendario=" + calendario + "]";
    }

    
}
