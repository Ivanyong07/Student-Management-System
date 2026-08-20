package com.store.demo.user.entity;

import jakarta.persistence.Entity;

@Entity
public class Student extends User {

    private String course;

    public Student(String username, String firstname, String lastname,
            String password, Role role, String email, String contactNumber, String course) {

        super(username, firstname, lastname, password, role, email, contactNumber);

        this.course = course;

    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
