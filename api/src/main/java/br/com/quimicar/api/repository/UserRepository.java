package br.com.quimicar.api.repository;

import br.com.quimicar.api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> { }