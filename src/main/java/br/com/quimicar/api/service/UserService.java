package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.UserEntity;
import br.com.quimicar.api.utils.UserDto;

import java.util.List;

public interface UserService {
    UserEntity save(UserDto user);
    List<UserEntity> findAll();
    UserEntity findByEmail(String email);
}
