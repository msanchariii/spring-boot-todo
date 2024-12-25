package com.imposters.todo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Table(name = "tasks")
public class Task {

//	id
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	/*
//	user (mapped to User entity)
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)  // This will create a foreign key for user
	private User user;
	*/

//	title
	@Column(name = "title", nullable = false, length = 45)
	private String title;

//	completed
	private boolean completed;

}
