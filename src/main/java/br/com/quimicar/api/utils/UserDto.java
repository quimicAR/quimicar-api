package br.com.quimicar.api.utils;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @JsonView(View.UserSimpleView.class)
    private String fullName;
    
    @JsonView(View.UserSimpleView.class)
    private String email;

    private String password;

    @JsonView(View.UserSimpleView.class)
    private String token;

    @JsonView(View.UserSimpleView.class)
    private Boolean enabled;

    @JsonView(View.UserSimpleView.class)
    private String role;
}
