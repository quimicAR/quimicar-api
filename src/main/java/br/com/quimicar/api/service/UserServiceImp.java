package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.UserEntity;
import br.com.quimicar.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp (UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public List<UserEntity> findAll() { return userRepository.findAll(); }

    @Override
    public UserEntity findByEmail(String email) {return userRepository.findByEmail(email); }

    @Override
    public UserEntity save(UserEntity user) { return userRepository.save(user); }

}
