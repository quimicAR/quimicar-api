//package br.com.quimicar.api.entity;
//
//import br.com.quimicar.api.utils.View;
//import com.fasterxml.jackson.annotation.JsonView;
//import lombok.Getter;
//
//import javax.persistence.*;
//import java.util.UUID;
//
//@Table(name = "permissions")
//@Entity
//@Getter
//public class Permission {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID permission_id;
//
//    @JsonView({View.PermissionView.class, View.UserView.class})
//    @Column(name = "name", nullable = false, updatable = false, unique = true)
//    private String name;
//}