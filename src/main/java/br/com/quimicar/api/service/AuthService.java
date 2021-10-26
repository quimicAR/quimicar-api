package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.User;
import br.com.quimicar.api.utils.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AuthService {
    User register(UserDto user);
    UserDto login(UserDto user) throws JsonProcessingException;
}
