package br.com.fiap.planiks.planiks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.planiks.planiks.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
    
}
