package br.com.fiap.planiks.planiks.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.planiks.planiks.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
    Page<Evento> findByEventoIdContaining(String busca, org.springframework.data.domain.Pageable pageable);

    void saveAll(List<Object> of);

    static Page<Evento> findAll(org.springdoc.core.converters.models.Pageable pageable) {
        return null;
    }
}