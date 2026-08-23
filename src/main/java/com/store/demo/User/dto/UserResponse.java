package com.store.demo.user.dto;

import com.store.demo.user.entity.Admin;
import com.store.demo.user.entity.Role;
import com.store.demo.user.entity.Student;
import com.store.demo.user.entity.Teacher;
import com.store.demo.user.entity.User;

public class UserResponse {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private Role role;
    private String email;
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

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.role = user.getRole();
        this.email = user.getEmail();
        this.contactNumber = user.getContactNumber();

        if (user instanceof Admin admin) {
            this.officeNumber = admin.getOfficeNumber();

        } else if (user instanceof Student student) {
            this.studentId = student.getStudentId();
            this.course = student.getCourse();
            this.gpa = student.getGpa();
            this.enrollmentDate = student.getEnrollmentDate();
            this.advisor = student.getAdvisor();

        } else if (user instanceof Teacher teacher) {
            this.subject = teacher.getSubject();
        }
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
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

    public String getCourse() {
        return course;
    }

    public String getStudentId() {
        return studentId;
    }

    public Double getGpa() {
        return gpa;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getAdvisor() {
        return advisor;
    }

}
