package br.com.quimicar.api.repository;

import br.com.quimicar.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role getByName(String name);
}