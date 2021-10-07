package br.com.quimicar.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/elements/**", "/api/login", "/api/register").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/management/**").hasAuthority(Permissions.ELEMENT_WRITE.name())
                .antMatchers(HttpMethod.POST, "/api/management/**").hasAuthority(Permissions.ELEMENT_WRITE.name())
                .antMatchers(HttpMethod.PUT, "/api/management/**").hasAuthority(Permissions.ELEMENT_WRITE.name())
                .antMatchers(HttpMethod.GET, "/api/management/**").hasAuthority(Permissions.ELEMENT_READ.name())
                .antMatchers("/api/management/**").hasAnyRole(Roles.ADMIN.name())
                .anyRequest()
               .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123456"))
                .roles(Roles.ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                admin
        );
    }
}
