package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity save(UserEntity user);
    List<UserEntity> findAll();
    UserEntity findByEmail(String email);
}
