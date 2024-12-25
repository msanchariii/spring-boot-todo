package com.imposters.todo.service;

import com.imposters.todo.model.Task;
import com.imposters.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public Task getTaskById(Long id) {
		return taskRepository.findById(id).orElse(null);
	}

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	public Task updateTask(Long id, Task task) {
		Task existingTask = taskRepository.findById(id).orElse(null);
		if (existingTask == null) {
			return null;
		}
		existingTask.setTitle(task.getTitle());
		existingTask.setCompleted(task.isCompleted());
		return taskRepository.save(existingTask);
	}

	public Task toggleComplete(Long id) {
		Task existingTask = taskRepository.findById(id).orElse(null);
		if (existingTask == null) {
			return null;
		}
		existingTask.setCompleted(!existingTask.isCompleted());
		return taskRepository.save(existingTask);
	}
}
