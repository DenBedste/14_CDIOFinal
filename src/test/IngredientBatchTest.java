package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import data.DALException;
import data.dao.IngredientBatchDAO;
import data.dao.StorageDAO;
import data.dto.IngredientBatchDTO;
import data.dto.IngredientDTO;

public class IngredientBatchTest {

	IngredientBatchDAO instance;
	IngredientBatchDTO ibd1;
	IngredientBatchDTO ibd2;
	IngredientBatchDTO ibd3;
	IngredientBatchDTO ibd4;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		StorageDAO sd = new StorageDAO();
		sd.deleteFile(IngredientBatchDAO.class.getSimpleName());	
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		StorageDAO sd = new StorageDAO();
		sd.deleteFile(IngredientBatchDAO.class.getSimpleName());
	}
	
	@Before
	public void setUp() throws Exception {
		instance = IngredientBatchDAO.getInstance();
		
		ibd1 = new IngredientBatchDTO();
		ibd1.setIbID(1);
		ibd1.setAmount(3.75);
		ibd1.setIngredientId(5);
		
		ibd2 = new IngredientBatchDTO();
		ibd2.setIbID(104);
		ibd2.setAmount(4.222);
		ibd2.setIngredientId(5);
		
		ibd3 = new IngredientBatchDTO();
		ibd3.setIbID(99);
		ibd3.setAmount(5.4);
		ibd3.setIngredientId(3);
		
		ibd4 = new IngredientBatchDTO();
		ibd4.setIbID(66);
		ibd4.setAmount(7.77);
		ibd4.setIngredientId(32);
	
		try {
			instance.createIngredientBatch(ibd1);
			instance.createIngredientBatch(ibd2);
			instance.createIngredientBatch(ibd3);
		} catch(DALException e) {
		}
	}

	@Test
	public void testGetIngredientBatch() throws DALException {
		IngredientBatchDTO tempIbd = instance.getIngredientBatch(1);
		assertEquals(ibd1.getIbID(), tempIbd.getIbID());
	}

	@Test
	public void testGetIngredientBatchList() {
		//Check if .testGetIngredientList returns ingredient10/20
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;
		
		for (IngredientBatchDTO tempIbd : instance.getIngredientBatchList()) {
			if (tempIbd.getIbID() == 1)
				test1 = true;
			else if(tempIbd.getIbID() == 104)
				test2 = true;
			else if(tempIbd.getIbID() == 99)
				test3 = true;
		}
		
		assertTrue(test1 && test2 && test3);
	}

	@Test
	public void testGetIngredientBatchListInt() throws DALException {
		//Check if .testGetIngredientList returns ingredient10/20
		boolean test1= false;
		boolean test2 = false;
		
		for (IngredientBatchDTO tempIbd : instance.getIngredientBatchList(5)) {
			if (tempIbd.getIbID() == 1)
				test1 = true;
			else if(tempIbd.getIbID() == 104)
				test2 = true;
		}
		
		assertTrue(test1 && test2);
	}

	@Test
	public void testCreateIngredientBatch() throws DALException {
		instance.createIngredientBatch(ibd4);
		IngredientBatchDTO tempIbd = instance.getIngredientBatch(66);
		assertEquals(ibd4.getIbID(), tempIbd.getIbID());
	}

	@Test
	public void testUpdateIngredientBatch() {
		try {
			ibd1.setAmount(9.1);
			instance.updateIngredientBatch(ibd1);
			assertTrue(ibd1.getAmount() == 9.1);
		} catch(DALException e) {
		fail("Ingredient batch not found");
		}
	}
}