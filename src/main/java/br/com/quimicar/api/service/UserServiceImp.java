package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.UserEntity;
import br.com.quimicar.api.repository.RoleRepository;
import br.com.quimicar.api.repository.UserRepository;
import br.com.quimicar.api.utils.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImp (UserRepository userRepository,  RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserEntity> findAll() {
        try {
            return userRepository.findAll();
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Users Not Found", error);
        }
    }

    @Override
    public UserEntity findByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, email + "User Email Not Found", error);
        }
    }


    @Override
    public UserEntity save(UserDto user) {
        try {
            UserEntity create = new UserEntity();

            create.setEmail(user.getEmail());
            create.setPassword(user.getPassword());
            create.setEnabled(true);
            create.setRole(roleRepository.getByName("ROLE_USER"));
            create.setToken_expired(false);

            return userRepository.save(create);
        } catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, " User already exists!", error);
        }
    }

}
