package com.prash.inform.repository;

import org.springframework.data.repository.CrudRepository;

import com.prash.inform.model.ProjectTask;

public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long>{
 
	ProjectTask getById(Long id);
}
