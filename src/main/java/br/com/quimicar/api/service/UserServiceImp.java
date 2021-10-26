package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.Role;
import br.com.quimicar.api.entity.User;
import br.com.quimicar.api.repository.RoleRepository;
import br.com.quimicar.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.*;


@Service @RequiredArgsConstructor @Slf4j
public class UserServiceImp implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findAll(String email, String role) {
        try {
            List<User> users;

            if(email != null || role != null) users = userRepository.findByEmailOrRole_Name(email, role);
            else users = userRepository.findAll();

            return users;
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error trying to list the users!", error);
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public User update(UUID id, User user) {
        User update = userRepository.findById(id);
        Role role = roleRepository.getByName(user.getRole().getName());

        update.setRole(role);
        update.setFullName(user.getFullName());
        update.setEmail(user.getEmail());
        update.setEnabled(user.isEnabled());
        update.setPassword(user.getPassword());

        return userRepository.save(update);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if(user == null || !user.isEnabled()) {
            throw new UsernameNotFoundException("User " + username + " not found!");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), authorities);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public User findById(UUID id) {
        return userRepository.findById(id);
    }
}