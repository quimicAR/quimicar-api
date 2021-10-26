package br.com.quimicar.api.utils;

import java.io.IOException;
import java.util.Date;

import br.com.quimicar.api.entity.Role;
import br.com.quimicar.api.entity.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RequiredArgsConstructor
@Slf4j
public class JwtUtils {
    static final String KEY = "spring.jwt.sec";

    public static String generateToken(Authentication user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User userNotAuthenticated = new User();

        userNotAuthenticated.setEmail(user.getName());

        if (!user.getAuthorities().isEmpty()) {
            Role role = new Role();
            role.setName(user.getAuthorities().iterator().next().getAuthority());
            userNotAuthenticated.setRole(role);
        }

        String userJson = mapper.writeValueAsString(userNotAuthenticated);
        Date agora = new Date();
        Long hora = 1000L * 60L * 60L; // Uma hora

        log.info("Role defined for {} - {}", userNotAuthenticated.getEmail(), userNotAuthenticated.getRole().getName());

        return Jwts.builder().claim("userDetails", userJson).setIssuer("br.com.quimicar").setSubject(user.getName())
                .setExpiration(new Date(agora.getTime() + hora)).signWith(SignatureAlgorithm.HS512, KEY).compact();
    }

    public static Authentication parseToken(String token) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Token validation
        // TODO -> add KEY="spring.jwt.sec" to .ENV
        String credentialsJson = Jwts.parser().setSigningKey("spring.jwt.sec").parseClaimsJws(token).getBody().get("userDetails",
                String.class);
        User user = mapper.readValue(credentialsJson, User.class);

        // Builds our user with the data extracted from the token
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder().username(user.getEmail()).password("secret")
                .authorities(user.getRole().getName()).build();

        return new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(),
                userDetails.getAuthorities());
    }
}