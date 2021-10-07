package br.com.quimicar.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;

    @Column(name = "email", nullable = false, updatable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, updatable = false, unique = true)
    private String password;

    private boolean enabled;
    private boolean token_expired;
}