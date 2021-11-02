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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.UserListView.class)
    private UUID id;

    @JsonView({View.UserSimpleView.class, View.UserListView.class})
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    @JsonView({View.UserSimpleView.class, View.UserListView.class})
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @JsonView(View.UserListView.class)
    private boolean enabled;

    @JsonView(View.UserSimpleView.class)
    private String token;

    @OneToOne
    @JoinTable(name = "user_has_role",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "role_id", referencedColumnName = "role_id") })
    @JsonView({View.UserListView.class, View.UserSimpleView.class})
    private Role role;
}