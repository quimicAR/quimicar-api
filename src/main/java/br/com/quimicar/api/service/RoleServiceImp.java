package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.Role;
import br.com.quimicar.api.repository.RoleRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Role save(Role role) {
        log.info("Saving role: \n {}", role.getName());
        return roleRepository.save(role);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(UUID id) {
        roleRepository.deleteById(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Role> findAll() { return roleRepository.findAll(); }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Role update(UUID id, Role role) {
        Role update = roleRepository.getById(id);
        Role nameExists = roleRepository.getByName(role.getName());

        if(nameExists != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"This Role name already exists!");

        log.info("Updating Role {} to {}", update.getName(),role.getName());
        update.setName(role.getName());
        update.setRole_id(id);

        return roleRepository.save(update);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Role getById(UUID id) {
        Role role = roleRepository.getById(id);
        log.info("Getting role: \n {} - {}", id, role.getName());
        return role;
    }
}
