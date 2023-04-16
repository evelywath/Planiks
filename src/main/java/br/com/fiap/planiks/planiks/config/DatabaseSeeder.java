package br.com.fiap.planiks.planiks.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.planiks.planiks.models.Prazo;
import br.com.fiap.planiks.planiks.repository.PrazoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    PrazoRepository prazoRepository;

    @Override
    public void run(String... args) throws Exception {

        LocalDateTime agora = LocalDateTime.now();

        prazoRepository.saveAll(List.of(
            new Prazo(1L,agora,"UTC-8"),
            new Prazo(1L,agora,"GMT+0"),
            new Prazo(1L,agora,"GMT-3")
        ));
    }
}

