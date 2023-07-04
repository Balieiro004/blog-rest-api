package com.balieiro.blog.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*Classe para encriptogragar as senhas, /*Usando para a classe custiUserDetailsService valuidar a entrada*/
public class PasswordGeneratorEncoder {
    public static void main(String[] args){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("balieiro"));
    }
}
