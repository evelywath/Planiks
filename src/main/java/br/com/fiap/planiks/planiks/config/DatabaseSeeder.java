package br.com.fiap.planiks.planiks.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.planiks.planiks.models.Evento;
import br.com.fiap.planiks.planiks.models.Prazo;
import br.com.fiap.planiks.planiks.repository.EventoRepository;
import br.com.fiap.planiks.planiks.repository.PrazoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    private static final Object Evento = null;

    @Autowired
    PrazoRepository prazoRepository;

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public void run(String... args) throws Exception {

        LocalDateTime agora = LocalDateTime.now();

        prazoRepository.saveAll(List.of(
            new Prazo(1L,agora,"UTC-8"),
            new Prazo(1L,agora,"GMT+0"),
            new Prazo(1L,agora,"GMT-3")
        ));

        
        Evento ev1 = new Evento(1L, "Prova", "Roxo", "Provas", "Conteúdo: JavaFX", 1L, true, null);
        Evento ev2 = new Evento(1L, "Fazer almoço", "Verde", "Deveres", "Tirar mistura pra descongelar", 1L, true, null);
        Evento ev3 = new Evento(1L, "Passar boss", "Lilás", "Jogos", "Fazer side-quest se der", 1L, true, null);

        //eventoRepository.saveAll(List.of(ev1, ev2, ev3));

        eventoRepository.saveAll(List.<Evento>of(ev1, ev2, ev3));
    }
}