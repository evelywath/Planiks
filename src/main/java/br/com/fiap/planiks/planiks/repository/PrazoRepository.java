package br.com.fiap.planiks.planiks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.planiks.planiks.models.Prazo;

public interface PrazoRepository extends JpaRepository<Prazo, Long>{
    
}