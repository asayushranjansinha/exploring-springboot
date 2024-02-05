package com.ayushranjan.ecommercespringboot.services.auth;

import com.ayushranjan.ecommercespringboot.dto.SignupRequest;
import com.ayushranjan.ecommercespringboot.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
    boolean hasUserWithEmail(String email);
}
