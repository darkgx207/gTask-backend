package online.dg7.gTaskAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import online.dg7.gTaskAPI.models.Task;
import online.dg7.gTaskAPI.repositories.TaskRepository;

@RestController
@RequestMapping("/task") @CrossOrigin("http://localhost:4200")
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;

	@GetMapping({"/{id}","/"}) 
	public List<Task> getTask(@PathVariable(required = false) Integer id) {
		if (id != null) {
			Task res = taskRepository.getTask(id);
			return (res != null) ? List.of(res) : List.of();
		}
		return taskRepository.findAll();
		
	}

	@PostMapping("/")
	public Task saveTask(@RequestBody Task json) {
		if (json != null) {
			System.out.println(json);
			return taskRepository.save(json);
		}
		return null;
	}

	@PostMapping("/delete")
	public ResponseEntity<?> deleteTask(@RequestBody Task json) {
		if (json != null) {
			try {
				this.taskRepository.deleteById(json.getId());
				return ResponseEntity.ok().build();
			} catch (Exception e) { }
		}
		return ResponseEntity.badRequest().build();
	}
}
