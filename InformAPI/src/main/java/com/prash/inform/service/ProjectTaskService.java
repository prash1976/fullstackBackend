package com.prash.inform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prash.inform.model.ProjectTask;
import com.prash.inform.repository.ProjectTaskRepository;

@Service
public class ProjectTaskService {
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;	
	
	public ProjectTask saveOrUpdate(ProjectTask projectTask) {
		
		if(projectTask.getStatus() == null || projectTask.getStatus() =="") {
			projectTask.setStatus("TO_DO");
		}
		return projectTaskRepository.save(projectTask);
	}
	
	public Iterable<ProjectTask> getAll(){
		return projectTaskRepository.findAll();
	}
	
	public ProjectTask findById(Long id) {
		return projectTaskRepository.getById(id);
	}
	
	public void deleteById(Long id) {
		ProjectTask projectTask = findById(id);
		projectTaskRepository.delete(projectTask);
		
	}

}
