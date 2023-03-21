package br.com.fiap.planiks.planiks.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Prazo {
   private LocalDate diaComeco;
   private LocalDate diaFim;
   private LocalDateTime horasComeco;
   private LocalDateTime horasFim;
   private String fuso;

public Prazo(LocalDate diaComeco, LocalDate diaFim, LocalDateTime horasComeco, LocalDateTime horasFim, String fuso) {
    this.diaComeco = diaComeco;
    this.diaFim = diaFim;
    this.horasComeco = horasComeco;
    this.horasFim = horasFim;
    this.fuso = fuso;
}

public LocalDate getDiaComeco() {
    return diaComeco;
}
public void setDiaComeco(LocalDate diaComeco) {
    this.diaComeco = diaComeco;
}
public LocalDate getDiaFim() {
    return diaFim;
}
public void setDiaFim(LocalDate diaFim) {
    this.diaFim = diaFim;
}
public LocalDateTime getHorasComeco() {
    return horasComeco;
}
public void setHorasComeco(LocalDateTime horasComeco) {
    this.horasComeco = horasComeco;
}
public LocalDateTime getHorasFim() {
    return horasFim;
}
public void setHorasFim(LocalDateTime horasFim) {
    this.horasFim = horasFim;
}
public String getFuso() {
    return fuso;
}
public void setFuso(String fuso) {
    this.fuso = fuso;
}

@Override
public String toString() {
    return "Prazo [diaComeco=" + diaComeco + ", diaFim=" + diaFim + ", horasComeco=" + horasComeco + ", horasFim="
            + horasFim + ", fuso=" + fuso + "]";
}


}