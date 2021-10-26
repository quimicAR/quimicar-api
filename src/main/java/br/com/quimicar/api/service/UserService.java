package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.UUID;

public interface UserService extends UserDetailsService {

    List<User> findAll(String email, String role_name);
    User findById(UUID id);
    User update(UUID id, User user);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    void delete(UUID id);
}

