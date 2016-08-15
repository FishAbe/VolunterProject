package cs544.mum.edu.models;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Task {
	
	@Id @GeneratedValue
	private int id;
	
	private String taskName;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private String neededResources;
	
	@Enumerated(EnumType.STRING)
	private Status status;
    
	public Task(){
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNeededResources() {
		return neededResources;
	}

	public void setNeededResources(String neededResources) {
		this.neededResources = neededResources;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	

}
