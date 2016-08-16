package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import cs544.mum.edu.dataaccess.ProjectDAO;
import cs544.mum.edu.models.Project;

public class ProjectDaoTest {
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void deletProjectTest(){
		
		ProjectDAO projectDao = new ProjectDAO();
		try {
			
			//Arrange
			Project project = projectDao.getProjectById(2);
			projectDao.deleteProject(project);
			
			//Act
			project = projectDao.getProjectById(2);
			
			//Assert
			assertNull(project);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
