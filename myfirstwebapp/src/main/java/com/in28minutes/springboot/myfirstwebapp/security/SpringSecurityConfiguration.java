package com.in28minutes.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;
import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    //In Memory
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){

        UserDetails userDetails = createNewUser("in28minutes", "dummy");
        UserDetails userDetails2 = createNewUser("ranga", "dummydummy");

        return new InMemoryUserDetailsManager(userDetails, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                                    .username(username)
                                    .password(password)
                                    .roles("USER", "ADMIN")
                                    .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // All URLs are protected
    // A login form is shown for unauthorized requests
    // CSRF disable
    // Frames

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
          auth -> auth.anyRequest().authenticated()
        )
        .formLogin(withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .headers(headers-> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return httpSecurity.build();
    }
}
