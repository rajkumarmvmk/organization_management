package com.example.siliconvalley_prvtd_lmtd;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public PasswordEncoder passwordEncoders(){
        return new BCryptPasswordEncoder(11);
    }
    }





