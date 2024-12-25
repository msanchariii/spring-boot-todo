package com.imposters.todo.controller;


import com.imposters.todo.model.Task;
import com.imposters.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
	public List<Task> getTask() {
		return taskService.getAllTasks();
	}

	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}

	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}

	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
		return taskService.updateTask(id, task);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
	}

	@PutMapping("/{id}/toggle")
	public Task completeTask(@PathVariable Long id) {
		return taskService.toggleComplete(id);
	}

}
