package br.com.quimicar.api.repository;

import br.com.quimicar.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
    User findById(UUID id);
    List<User> findByEmailOrRole_Name(String email, String role_name);
    void deleteById(UUID id);
}