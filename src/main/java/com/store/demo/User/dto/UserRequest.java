package com.store.demo.user.dto;

import jakarta.validation.constraints.NotBlank;

import com.store.demo.user.entity.Role;

public class UserRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "First name is required")
    private String firstname;

    @NotBlank(message = "Password is required")
    private String lastname;

    @NotBlank(message = "Password is required")
    private String password;

    private Role role;
    private String email;
    private String course;
    private String contactNumber;
    private String officeNumber;
    private String subject;

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public String getSubject() {
        return subject;
    }

}
