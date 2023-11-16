package com.infosys.anchal.todoList.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.anchal.todoList.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
