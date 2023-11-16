package com.infosys.anchal.todoList.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="task_01")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private boolean completed;
	public Task(String title, String description, boolean completed) {
		super();
		this.title = title;
		this.description = description;
		this.completed = completed;
	}
	public Task() {
		super();
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
