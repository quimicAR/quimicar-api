package br.com.quimicar.api.controller;

import br.com.quimicar.api.entity.Role;
import br.com.quimicar.api.service.RoleService;
import br.com.quimicar.api.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class RoleController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping(value = "/roles")
    public ResponseEntity<List<Role>> listRoles() {
        return ResponseEntity.ok().body(roleService.findAll());
    }

    @PostMapping(value = "/roles")
    public ResponseEntity<Role> save(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role").toUriString());
        return ResponseEntity.created(uri).body(roleService.save(role));
    }

    @DeleteMapping(value = "/roles/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable UUID id) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/id").toUriString());
        roleService.deleteById(id);
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/roles/{id}")
    public ResponseEntity<Role> update(@PathVariable UUID id, @RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/id").toUriString());
        return ResponseEntity.created(uri).body(roleService.update(id, role));
    }

    @GetMapping(value = "/roles/{id}")
    public ResponseEntity<Role> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(roleService.getById(id));
    }
}
