package br.com.quimicar.api.entity;

import br.com.quimicar.api.utils.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.UserView.class)
    private UUID id;

    @Column(name = "email", nullable = false, updatable = false, unique = true)
    @JsonView(View.UserView.class)
    private String email;

    @Column(name = "password", nullable = false, updatable = false, unique = true)
    private String password;

    @JsonView(View.UserView.class)
    private boolean enabled;

    @JsonView(View.UserView.class)
    private boolean token_expired;

    @OneToOne
    @JsonView(View.UserView.class)
    private RoleEntity role;
}