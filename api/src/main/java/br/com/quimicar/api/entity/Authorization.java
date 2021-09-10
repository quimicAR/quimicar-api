package br.com.quimicar.api.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "user_authenticated")
@Entity
@Data
public class Authorization {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer authorization_id;
    @Column(name = "authorization_email", nullable = false, updatable = false, unique = true)
    private String authorization_email;
}