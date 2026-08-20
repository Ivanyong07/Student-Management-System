package com.store.demo.user;

import org.springframework.stereotype.Service;

import com.store.demo.user.dto.UserRequest;
import com.store.demo.user.entity.Admin;
import com.store.demo.user.entity.Teacher;
import com.store.demo.user.entity.User;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest request) {
        User user = switch (request.getRole()) {
            case ADMIN -> new Admin(request.getUsername(), request.getFirstname(), request.getLastname(),
                    request.getPassword(), request.getRole(), request.getEmail(), request.getCourse(),
                    request.getContactNumber(), request.getOfficeNumber());
            case STUDENT -> new Stduent();
            case TEACHER -> new Teacher();
        };
        return userRepository.save(user);
    }

}
