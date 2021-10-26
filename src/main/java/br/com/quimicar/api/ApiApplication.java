package br.com.quimicar.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(10); }

}

/* TODO
 *   - Create RoleController - Backend
 *       - Implement those http methods Create/Delete/Put
 *   -
 *   - Create Administrator dashboard - Frontend
 *        - Burguer menu with the above options
 *       - Admin needs to Create/Delete/Update a Role
 *       - Admin needs to Create/Delete/Update a User
 *       - Admin needs to Create/Delete/Update a Element
 *       - Filter users by roleName or e-mail (Will complete exercise b. )
 *       - Authentication
 *  - Create documentation for the Application
 * */