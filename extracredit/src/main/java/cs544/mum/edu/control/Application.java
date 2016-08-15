package cs544.mum.edu.control;

import java.util.Date;

import cs544.mum.edu.dataaccess.ProjectDAO;
import cs544.mum.edu.models.Project;
import cs544.mum.edu.models.Status;
import cs544.mum.edu.models.Task;

public class Application {
	private static ProjectDAO _projectDao = new ProjectDAO();

	public static void main(String[] args) {
		AddProject();

	}
	
	public static void AddProject(){
		Project project = new Project();
		project.setProjectName("ProjectName1");
		project.setDescription("This is description about the project");
		Date startDate = new Date(2014, 10, 24);
		project.setStartDate(startDate);
		Date endDate = new Date(2016, 10, 24);
	    project.setEndDate(endDate);
		
	    project.setProjectLocation("IOWA");
	    project.setStatus(Status.TODO);
	    
	    try {
			_projectDao.AddProject(project);
			System.out.println("Project Added");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    Task task = new Task();
	    task.setTaskName("Task1");
	    task.setStartDate(startDate);
	    task.setEndDate(endDate);
	    task.setNeededResources("List of needed Resources");
	    task.setProject(project);
	    
	    try {
			_projectDao.addTask(task);
			System.out.println("Task Added");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}

}
