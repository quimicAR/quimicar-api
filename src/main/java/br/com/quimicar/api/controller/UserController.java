package br.com.quimicar.api.controller;

import br.com.quimicar.api.entity.UserEntity;
import br.com.quimicar.api.service.UserService;
import br.com.quimicar.api.utils.UserDto;
import br.com.quimicar.api.utils.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping(value="/users") // List users for Admin
    @JsonView(View.UserView.class)
    public ResponseEntity<List<UserEntity>> listUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/register") // Create new User
    @JsonView(View.UserView.class)
    public ResponseEntity<UserEntity> register(@RequestBody UserDto user){

        UserEntity saved = userService.save(user);

        System.out.println(saved.getEmail());
        System.out.println(saved.getPassword());
        System.out.println(saved.getRole());

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login") // Login the User/Admin account
    @JsonView(View.UserView.class)
    public ResponseEntity<UserEntity> login(@RequestBody UserEntity user){
        System.out.println("Loging in");

        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        UserEntity exists = userService.findByEmail(user.getEmail());

        return new ResponseEntity<>(exists, HttpStatus.OK);

    }
}
