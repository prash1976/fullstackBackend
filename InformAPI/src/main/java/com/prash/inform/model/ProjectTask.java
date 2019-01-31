package com.prash.inform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ProjectTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Summary cannot be blank")
	private String summary;
	private String acceptanceCriterea;
	private String status;
	
	public ProjectTask() {
		
	}	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAcceptanceCriterea() {
		return acceptanceCriterea;
	}
	public void setAcceptanceCriterea(String acceptanceCriterea) {
		this.acceptanceCriterea = acceptanceCriterea;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		
		return "ProjectTask [id=" + id + ", summary=" + summary + ", acceptanceCriterea=" + acceptanceCriterea
				+ ", status=" + status + "]";
	}

}
