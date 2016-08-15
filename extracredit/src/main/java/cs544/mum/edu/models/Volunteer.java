package cs544.mum.edu.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Volunteer extends User {
	
	private String description;
	
	@OneToMany
	@JoinColumn(name="taskId")
	private List<Task> workson = new ArrayList<Task>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Task> getWorkson() {
		return workson;
	}

	public void setWorkson(List<Task> workson) {
		this.workson = workson;
	}
	
	

}
