package br.com.fiap.planiks.planiks.models;

import java.time.LocalDateTime;

public class Prazo {
   private LocalDateTime diaHora;
   private String fuso;

    public Prazo(LocalDateTime diaHora, String fuso) {
        this.diaHora = diaHora;
        this.fuso = fuso;
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
   
}