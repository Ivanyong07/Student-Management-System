package com.store.demo.user;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.store.demo.NotFoundException;
import com.store.demo.user.dto.UserRequest;
import com.store.demo.user.dto.UserResponse;
import com.store.demo.user.entity.Admin;
import com.store.demo.user.entity.Student;
import com.store.demo.user.entity.Teacher;
import com.store.demo.user.entity.User;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(UserRequest request) {

        String hashedPassword = passwordEncoder.encode(request.getPassword());
        User user = switch (request.getRole()) {
            case ADMIN -> new Admin(request.getUsername(), request.getFirstname(), request.getLastname(),
<<<<<<< Updated upstream
                    request.getPassword(), request.getRole(), request.getEmail(), request.getContactNumber(),
                    request.getOfficeNumber());
            case STUDENT -> new Student(request.getUsername(), request.getFirstname(), request.getLastname(),
                    request.getPassword(), request.getRole(), request.getEmail(), request.getContactNumber(),
                    request.getCourse());
            case TEACHER -> new Teacher(request.getUsername(), request.getFirstname(), request.getLastname(),
                    request.getPassword(), request.getRole(), request.getEmail(), request.getContactNumber(),
=======
                    hashedPassword, request.getRole(), request.getEmail(), request.getContactNumber(),
                    request.getOfficeNumber());

            case STUDENT -> new Student(request.getUsername(), request.getFirstname(), request.getLastname(),
                    hashedPassword, request.getRole(), request.getEmail(), request.getContactNumber(),
                    request.getCourse(), request.getStudentId(), request.getGpa(), request.getEnrollmentDate(),
                    request.getAdvisor());

            case TEACHER -> new Teacher(request.getUsername(), request.getFirstname(), request.getLastname(),
                    hashedPassword, request.getRole(), request.getEmail(), request.getContactNumber(),
>>>>>>> Stashed changes
                    request.getSubject());
        };
        User saved = userRepository.save(user);
        return new UserResponse(saved);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
    }

    public UserResponse updateUser(UserRequest request, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        user.setUsername(request.getUsername());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setContactNumber(request.getContactNumber());

        if (user instanceof Admin admin) {
            admin.setOfficeNumber(request.getOfficeNumber());

        } else if (user instanceof Student student) {
            student.setCourse(request.getCourse());
            student.setStudentId(request.getStudentId());
            student.setGpa(request.getGpa());
            student.setEnrollmentDate(request.getEnrollmentDate());
            student.setAdvisor(request.getAdvisor());

        } else if (user instanceof Teacher teacher) {
            teacher.setSubject(request.getSubject());
        }

        User saved = userRepository.save(user);
        return new UserResponse(saved);
    }

    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        return new UserResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(UserResponse::new).toList();
    }

}
