package com.store.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.demo.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
