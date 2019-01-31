package com.prash.inform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prash.inform.model.ProjectTask;
import com.prash.inform.service.ProjectTaskService;


@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {
	
	@Autowired
	private ProjectTaskService projectTaskService;
	
	@PostMapping("")
	public ResponseEntity<?> addPT(@Valid @RequestBody ProjectTask projectTask, BindingResult result){
		
		if(result.hasErrors()) {
			
			Map<String,String> erorrMap = new HashMap<>();
			for(FieldError error : result.getFieldErrors()) {
				erorrMap.put(error.getField(), error.getDefaultMessage());
			}
		return new ResponseEntity<Map<String,String>>(erorrMap,HttpStatus.BAD_REQUEST);
			
		}
		ProjectTask newPT = projectTaskService.saveOrUpdate(projectTask);
		return new ResponseEntity<ProjectTask>(newPT,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Iterable<ProjectTask> getAll(){
		return projectTaskService.getAll();
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<ProjectTask> getById(@PathVariable Long pid) {
		ProjectTask pt = projectTaskService.findById(pid);
		
		return new ResponseEntity<ProjectTask>(pt,HttpStatus.OK);
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<?> deleteProjectTask(@PathVariable Long pid){
		projectTaskService.deleteById(pid);		
		return new ResponseEntity<String>("Project Task Deleted", HttpStatus.OK);
		
	}
	

}
