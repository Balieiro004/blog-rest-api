package com.balieiro.blog.service;

import com.balieiro.blog.payload.LoginDto;
import com.balieiro.blog.payload.RegisterDto;

public interface AuthService{
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
