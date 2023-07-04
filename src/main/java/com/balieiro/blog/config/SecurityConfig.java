package com.balieiro.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private UserDetailsService userDetailsService; /*Usando para a classe cystiYserDetailsService valuidar a entrada*/

    public SecurityConfig(UserDetailsService userDetailsService){ /*Usando para a classe cystiYserDetailsService valuidar a entrada*/
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();   /*Usando para a classe cystiYserDetailsService valuidar a entrada, USA PARA CODIFICAR AS SENHAS E DESCODIFICAR*/
    }

/*    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }*/

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                                .requestMatchers("/api/auth/**").permitAll()
                                .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /*Criando usuário e salvando na memória. Não é a forma certa de usar mais por enquanto vale*/
    /*Depois precisa ser autenticado pelo banco de dados*/
/*    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails balieiro = User.builder()
                .username("balieiro")
                .password(passwordEncoder().encode( "123456789"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode( "admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(balieiro, admin);
    }*/
}
