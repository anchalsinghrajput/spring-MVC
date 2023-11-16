package com.infosys.anchal.todoList.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.anchal.todoList.entity.Task;
import com.infosys.anchal.todoList.entity.User;

public interface TaskRepo extends JpaRepository<Task, Integer> {	
    List<Task> findByUser(User user);
    List<Task> findByUserId(int userId);
	List<Task> findByUserAndTitle(User user, String title);
	List<Task> findByUserAndDescription(User user, String description);
	List<Task> findByUserAndCompleted(User user, Boolean completed);
   
}