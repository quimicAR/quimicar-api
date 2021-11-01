package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.Role;
import br.com.quimicar.api.entity.User;
import br.com.quimicar.api.repository.RoleRepository;
import br.com.quimicar.api.repository.UserRepository;
import br.com.quimicar.api.utils.JwtUtils;
import br.com.quimicar.api.utils.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImp implements AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    @PreAuthorize("permitAll()")
    public User register(UserDto user) {
        User newUser = new User();
        Role role = roleRepository.getByName(user.getRole() == null ? "ROLE_USER" : user.getRole());
        User emailExists = userRepository.findByEmail(user.getEmail());

        if(emailExists != null) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "This e-mail it's already in use!");
        newUser.setFullName(user.getFullName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(role);
        newUser.setEnabled(user.getEnabled() != null ? user.getEnabled() : true);

        log.info("Created user {} with role {}", newUser.getEmail(), newUser.getRole().getName());
        return userRepository.save(newUser);
    }

    @Override
    @PreAuthorize("permitAll()")
    public UserDto login(UserDto credentials) throws JsonProcessingException, ResponseStatusException {
        try {
            User user = userRepository.findByEmail(credentials.getEmail());

            if(!user.isEnabled()) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "This account is inactive! Talk with the system Administrator");

            Authentication auth = new UsernamePasswordAuthenticationToken(credentials.getEmail(),credentials.getPassword());
            auth = authManager.authenticate(auth);

            credentials.setPassword(null);
            credentials.setToken(JwtUtils.generateToken(auth));
            user.setToken(JwtUtils.generateToken(auth));
            credentials.setRole(auth.getAuthorities().iterator().next().getAuthority());
            userRepository.save(user);
            return credentials;
        } catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Verify your e-mail and password!", error);
        }

    }

    @Override
    @PreAuthorize("permitAll()")
    public UserDto recover(String token) throws IOException {
        Authentication auth = JwtUtils.parseToken(token);
        User user = userRepository.findByEmail(auth.getName());
        UserDto userDto = new UserDto();
        userDto.setFullName(user.getFullName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().getName());
        userDto.setEnabled(user.isEnabled());
        userDto.setToken(user.getToken());
        return userDto;
    }
}
