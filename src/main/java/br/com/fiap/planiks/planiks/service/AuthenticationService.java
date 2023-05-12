package br.com.fiap.planiks.planiks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import br.com.fiap.planiks.planiks.repository.UsuarioRepository;

public class AuthenticationService implements UserDetailsManager {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                    .orElseThrow( () -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    @Override
    public void createUser(UserDetails user) {
        throw new UnsupportedOperationException("Usúario já cadastrado");
    }

    @Override
    public void updateUser(UserDetails user) {
        throw new UnsupportedOperationException("Usuário ou senha incorretos.");
    }

    @Override
    public void deleteUser(String username) {
        throw new UnsupportedOperationException("Método não suportado: deleteUser");
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        throw new UnsupportedOperationException("Senha incorreta, Deseja muda-la?");
    }

    @Override
    public boolean userExists(String username) {
        throw new UnsupportedOperationException("Usúario já existente.");
    }
}