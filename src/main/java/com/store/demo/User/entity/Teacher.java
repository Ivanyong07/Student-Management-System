package com.store.demo.user.entity;

import jakarta.persistence.Entity;

@Entity
public class Teacher extends User {

    private String subject;

    public Teacher(String username, String firstname, String lastname,
            String password, Role role, String email, String contactNumber, String subject) {

        super(username, firstname, lastname, password, role, email, contactNumber);

        this.subject = subject;

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
