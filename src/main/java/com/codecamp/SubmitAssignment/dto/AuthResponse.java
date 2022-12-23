package com.codecamp.SubmitAssignment.dto;


import lombok.Data;

@Data
public class AuthResponse {

    String username,accessToken;

    public AuthResponse(String username, String accessToken) {
        this.username = username;
        this.accessToken = accessToken;
    }
}
