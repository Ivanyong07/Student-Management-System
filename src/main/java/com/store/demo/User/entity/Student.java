package com.store.demo.user.entity;

import jakarta.persistence.Entity;

@Entity
public class Student extends User {

    private String course;
    private String studentId;
    private double gpa;
    private String enrollDate;
    private String advisor;

    protected Student() {

    }

    public Student(String username, String firstname, String lastname,
            String password, Role role, String email,
            String contactNumber, String course, String studentId, double gpa, String enrollDate, String advisor) {

        super(username, firstname, lastname, password, role, email, contactNumber);

        this.course = course;
        this.studentId = studentId;
        this.gpa = gpa;
        this.advisor = advisor;

    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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
        return enrollDate;
    }

    public void setEnrollmentDate(String enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }
}
