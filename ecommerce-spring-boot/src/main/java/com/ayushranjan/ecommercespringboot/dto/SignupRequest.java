package com.ayushranjan.ecommercespringboot.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class SignupRequest {
    private String email;
    private String password;
    private String name;
}
