package cs544.mum.edu.dataaccess;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	 * @throws Exception 
	 */
	public List<Project> getProjectByStatus(Status status) throws Exception{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Project> projects = new ArrayList<Project>();
		try{
			tx = session.beginTransaction();
			Query projectQuery = session.createQuery("FROM Project p WHERE p.status = :status");
			projectQuery.setParameter("status", status);
			
			projects = projectQuery.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		return projects;
	}
	public Project getProjectById(int projectId) throws Exception{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Project project = new Project();
		try{
			tx = session.beginTransaction();
			Query projectQuery = session.createQuery("FROM Project p WHERE p.projectId = :id");
			projectQuery.setParameter("id", projectId);
			
			project = (Project) projectQuery;
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		return project;
	}
	/**
	 * This method returns list of tasks for the provided project id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<Task> getTasksByProjectId(int projectId) throws Exception{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Task> tasks = new ArrayList<Task>();
		try{
			tx = session.beginTransaction();
			Query tasktQuery = session.createQuery("FROM Task p WHERE p.project.id = :id");
			tasktQuery.setParameter("id", projectId);
			
			tasks = tasktQuery.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		return tasks;
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
