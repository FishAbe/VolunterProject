package cs544.mum.edu.dataaccess;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs544.mum.edu.models.Project;
import cs544.mum.edu.models.Status;
import cs544.mum.edu.models.Task;

public class ProjectDAO {
    /**
     * Creates new project
     * @param project
     * @throws SystemException 
     * @throws IllegalStateException 
     */
	public void AddProject(Project project) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.persist(project);
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		
	}
	public void addTask(Task task) throws Exception{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.persist(task);
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	/***
	 *  Gets list of projects in the database
	 * @return Projects
	 */
	public List<Project> getAllProjects(){
		return new ArrayList<Project>();
	}
	/**
	 * Filters projects based on the provided status
	 * @param status
	 * @return
	 */
	public List<Project> getProjectByStatus(Status status){
		return new ArrayList<Project>();
	}
	/**
	 * Search Projects from the database based on the 
	 * provided location information
	 * @param Location
	 * @return
	 */
	public List<Project> searchProjectByLocation(String Location){
		return new ArrayList<Project>();
	}
	/**
	 * allow Admins to update Project information
	 * @param project
	 */
	public void updateProject(Project project){
		
	}
	/**
	 * Allow Admin to delete Projects
	 * @param project
	 */
	public void deleteProject(Project project){
		
	}
}
