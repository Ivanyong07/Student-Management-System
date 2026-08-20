package com.store.demo.user.entity;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User {

    private String officeNumber;

    public Admin(String username, String firstname, String lastname,
            String password, Role role, String email, String contactNumber, String officeNumber) {

        super(username, firstname, lastname, password, role, email, contactNumber);

        this.officeNumber = officeNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}
