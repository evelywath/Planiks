package br.com.fiap.planiks.planiks.models;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public record Credencial (String email, String senha) {
    
    public org.springframework.security.core.Authentication toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }

}
