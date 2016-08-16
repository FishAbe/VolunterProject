package cs544.mum.edu.control;

import java.util.List;

import cs544.mum.edu.dataaccess.ProjectDAO;
import cs544.mum.edu.models.Project;
import cs544.mum.edu.models.Status;
import cs544.mum.edu.models.Task;
import cs544.mum.edu.models.UserRole;
import cs544.mum.edu.models.Volunteer;

public class Application {
	private static ProjectDAO _projectDao = new ProjectDAO();

	public static void main(String[] args) {
		//AddProject();
		populateProjects();

	}
	
	public static void populateProjects() {
		
		try {
			List<Task> tasks=_projectDao.getTasksByProjectId(2);
			for(Task task : tasks){
			       System.out.println("Project Name"+task.getTaskName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void AddProject(){
		Project project = new Project();
		project.setProjectName("ProjectName1");
		project.setDescription("This is description about the project");
		project.setStartDate("12/12/2014");
	    project.setEndDate("12/12/2016");
		   
	    project.setProjectLocation("IOWA");
	    project.setStatus(Status.TODO);
	    
	    
	    Volunteer volunteer = new Volunteer();
	    volunteer.setFirstName("Fisseha");
	    volunteer.setLastName("Chari");
	    volunteer.setDescription("this is volunteer description");
	    volunteer.setUserRole(UserRole.VOLUNTEER);
	    
	    
	    Task task = new Task();
	    task.setTaskName("Task1");
	    task.setStartDate("11/10/2015");
	    task.setEndDate("10/10/2016");
	    task.setNeededResources("List of needed Resources");
	    task.setStatus(Status.TODO);
	    task.setVolunter(volunteer);
	    
	    Task task2 = new Task();
	    task.setTaskName("Task2");
	    task.setStartDate("11/10/2016");
	    task.setEndDate("10/10/2018");
	    task.setNeededResources("List of needed Resources");
	    task.setStatus(Status.TODO);
	    task.setVolunter(volunteer);
	    
	    project.addTask(task);
	    project.addTask(task2);
	    
	    
	    try {
			_projectDao.addTask(task);
			System.out.println("Task Added");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}

}
