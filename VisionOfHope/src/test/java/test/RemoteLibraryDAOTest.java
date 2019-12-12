package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs3733.main.DB.RemoteLibrariesDAO;

public class RemoteLibraryDAOTest {

	@Test
	public void testAddRemoteLibrary() {
		RemoteLibrariesDAO dao = new RemoteLibrariesDAO();
		boolean test=false;
		try {
			test = dao.addRemoteLib("testName", "testUrl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(test);
	}

}
