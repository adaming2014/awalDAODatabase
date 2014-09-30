/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.entity.Repairer;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author INTI0221
 */
public class RepairerDaoTest {
    
    public RepairerDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class RepairerDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        RepairerDao instance = new RepairerDao();
        List<Repairer> expResult = new ArrayList<>();
        List<Repairer> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class RepairerDao.
     */
//    @Test
    public void testCreate() {
        System.out.println("create");
        Repairer repairer = null;
        RepairerDao instance = new RepairerDao();
        boolean expResult = false;
        boolean result = instance.create(repairer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class RepairerDao.
     */
//    @Test
    public void testUpdate() {
        System.out.println("update");
        Repairer repairer = null;
        RepairerDao instance = new RepairerDao();
        boolean expResult = false;
        boolean result = instance.update(repairer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RepairerDao.
     */
//    @Test
    public void testDelete_Repairer() {
        System.out.println("delete");
        Repairer repairer = null;
        RepairerDao instance = new RepairerDao();
        boolean expResult = false;
        boolean result = instance.delete(repairer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RepairerDao.
     */
//    @Test
    public void testDelete_int() {
        System.out.println("delete");
        int id = 0;
        RepairerDao instance = new RepairerDao();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class RepairerDao.
     */
//    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        RepairerDao instance = new RepairerDao();
        Repairer expResult = null;
        Repairer result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
