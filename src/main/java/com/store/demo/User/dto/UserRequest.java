package com.store.demo.user.dto;

import jakarta.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "First name is required")
    private String firstname;

    @NotBlank(message = "Password is required")
    private String lastname;

}
