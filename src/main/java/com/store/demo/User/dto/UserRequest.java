package com.store.demo.user.dto;

import com.store.demo.user.entity.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.store.demo.user.entity.Role;

public class UserRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "First name is required")
    private String firstname;

    @NotBlank(message = "Last name is required")
    private String lastname;

    @NotBlank(message = "Password is required")
    private String password;

<<<<<<< Updated upstream
    private Role role;
    private String email;
    private String course;
    private String contactNumber;
    private String officeNumber;
    private String subject;

=======
    @NotNull(message = "Role is required")
    private Role role;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank
    private String contactNumber;

    // admin
    private String officeNumber;

    // teacher
    private String subject;

    // student
    private String course;
    private String studentId;
    private double gpa;
    private String enrollmentDate;
    private String advisor;

>>>>>>> Stashed changes
    public String getUsername() {
        return username;
    }

<<<<<<< Updated upstream
=======
    public void setUsername(String username) {
        this.username = username;
    }

>>>>>>> Stashed changes
    public String getFirstname() {
        return firstname;
    }

<<<<<<< Updated upstream
=======
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

>>>>>>> Stashed changes
    public String getLastname() {
        return lastname;
    }

<<<<<<< Updated upstream
=======
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

>>>>>>> Stashed changes
    public String getPassword() {
        return password;
    }

<<<<<<< Updated upstream
=======
    public void setPassword(String password) {
        this.password = password;
    }

>>>>>>> Stashed changes
    public Role getRole() {
        return role;
    }

<<<<<<< Updated upstream
=======
    public void setRole(Role role) {
        this.role = role;
    }

>>>>>>> Stashed changes
    public String getEmail() {
        return email;
    }

<<<<<<< Updated upstream
=======
    public void setEmail(String email) {
        this.email = email;
    }

>>>>>>> Stashed changes
    public String getCourse() {
        return course;
    }

<<<<<<< Updated upstream
=======
    public void setCourse(String course) {
        this.course = course;
    }

>>>>>>> Stashed changes
    public String getContactNumber() {
        return contactNumber;
    }

<<<<<<< Updated upstream
=======
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

>>>>>>> Stashed changes
    public String getOfficeNumber() {
        return officeNumber;
    }

<<<<<<< Updated upstream
=======
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

>>>>>>> Stashed changes
    public String getSubject() {
        return subject;
    }

<<<<<<< Updated upstream
=======
    public void setSubject(String subject) {
        this.subject = subject;
    }

>>>>>>> Stashed changes
}
