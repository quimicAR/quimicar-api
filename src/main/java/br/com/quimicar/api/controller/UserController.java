package br.com.quimicar.api.controller;

import br.com.quimicar.api.entity.User;
import br.com.quimicar.api.service.AuthService;
import br.com.quimicar.api.service.UserService;
import br.com.quimicar.api.utils.UserDto;
import br.com.quimicar.api.utils.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @GetMapping(value="/users")
    @JsonView(View.UserListView.class)
    public ResponseEntity<List<User>> listUsers(@RequestParam(required = false) String email, @RequestParam(required = false) String role) {
        log.info("Listing all users ");
        return ResponseEntity.ok().body(userService.findAll(email, role));
    }

    @PostMapping(value = "/register")
    @JsonView(View.UserSimpleView.class)
    public ResponseEntity<User> register(@RequestBody UserDto user){
        log.info("Registering user {}", user.getEmail());
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/register").toUriString());
        return ResponseEntity.created(uri).body(authService.register(user));
    }

    @PostMapping(value = "/login")
    @JsonView(View.UserSimpleView.class)
    public ResponseEntity<UserDto> login(@RequestBody UserDto user) throws JsonProcessingException {
        log.info("Logging user {}", user.getEmail());
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/login").toUriString());
        return ResponseEntity.created(uri).body(authService.login(user));
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/id").toUriString());
        log.info("Editing user {}", user.getEmail());
        return ResponseEntity.created(uri).body(userService.update(id, user));
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id) {
        log.info("Getting user {}", id);
        return ResponseEntity.ok().body(userService.findById(id));
    }


    @DeleteMapping (value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        userService.delete(id);
        log.info("Deleting user {}", id);
        return ResponseEntity.ok().build();
    }
}
