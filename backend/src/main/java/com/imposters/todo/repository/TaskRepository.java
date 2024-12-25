package com.imposters.todo.repository;

import com.imposters.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {



	/*
//	using JPA query naming convention to get all tasks by user id
	List<Task> findByUserId(Long userId);
	List<Task> findByTitleContaining(String title);

//	using native query to get all completed tasks
	@Query(value = "SELECT * FROM tasks WHERE is_completed = true", nativeQuery = true)
	List<Task> findCompletedTasks();
	*/
}
