package br.com.fiap.planiks.planiks.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.fiap.planiks.planiks.controllers.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthorizationFilter extends OncePerRequestFilter  {

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        
            var token = getToken(request);

            
            if (token != null){
                Usuario usuario = ((br.com.fiap.planiks.planiks.service.TokenService) tokenService).getUserByToken(token);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuario.getEmail(), null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

            // chama o proximo filtro 
            filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        var header = request.getHeader("Authorization"); // Bearer aieiaioehfsdjnfgjkdsbli

        if (header == null || !header.startsWith("Bearer ")){
            return null;
        }

        return header.replace("Bearer ", "");

    }

}