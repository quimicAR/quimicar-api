package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    Role save(Role role);
    void deleteById(UUID id);
    List<Role> findAll();
    Role update(UUID id, Role role);
    Role getById(UUID id);
}
