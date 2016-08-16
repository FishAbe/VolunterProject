package cs544.mum.edu.control;

import java.util.List;

import cs544.mum.edu.dataaccess.ProjectDAO;
import cs544.mum.edu.models.Project;
import cs544.mum.edu.models.Status;
import cs544.mum.edu.models.Task;

public class Application {
	private static ProjectDAO _projectDao = new ProjectDAO();

	public static void main(String[] args) {
		//AddProject();
		populateProjects();

	}
	
	public static void populateProjects() {
		
		try {
			List<Project> projects=_projectDao.getProjectByStatus(Status.TODO);
			for(Project project : projects){
			       System.out.println("Project Name"+project.getProjectName());
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
	    
	    Task task = new Task();
	    task.setTaskName("Task1");
	    task.setStartDate("11/10/2015");
	    task.setEndDate("10/10/2016");
	    task.setNeededResources("List of needed Resources");
	    task.setStatus(Status.TODO);
	    //task.setProject(project);
	    
	    project.addTask(task);
	    
	    try {
			_projectDao.addTask(task);
			System.out.println("Task Added");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}

}
