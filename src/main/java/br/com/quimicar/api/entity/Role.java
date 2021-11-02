package br.com.quimicar.api.entity;

import br.com.quimicar.api.utils.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "roles")
@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({View.UserSimpleView.class, View.UserListView.class})
    private UUID role_id;

    @Column(name = "name", nullable = false, updatable = true, unique = true)
    @JsonView({View.UserSimpleView.class, View.UserListView.class})
    private String name;
}
