/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IRepairerDao;
import fr.adaming.awal.entity.Repairer;
import fr.adaming.awal.util.RepairerUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author INTI0221
 */
public class RepairerDaoTest {

    private IRepairerDao repairerDao;

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
        repairerDao = new RepairerDao();
        dropTable();
    }

    @After
    public void tearDown() {
        repairerDao = null;
        dropTable();
    }

    private void dropTable() {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.createQuery("delete awal_db.repairer").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /**
     * Test of getAll method, of class RepairerDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");

        // Init expected results;
//        Repairer repairer1 = new Repairer().setAvailable(RepairerUtil.AVAILABLE);
//        Repairer repairer2 = new Repairer().setAvailable(RepairerUtil.AVAILABLE);
//        Repairer repairer3 = new Repairer().setAvailable(RepairerUtil.AVAILABLE);

        List<Repairer> expResult = new ArrayList<>();
//        expResult.add(repairer1);
//        expResult.add(repairer2);
//        expResult.add(repairer3);
//
//        repairerDao.create(repairer1);
//        repairerDao.create(repairer2);
//        repairerDao.create(repairer3);

        // Test
        List<Repairer> result = repairerDao.getAll();

        // Verify results
        assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class RepairerDao.
     */
    @Test
    public void testCreate() {
        System.out.println("create");

        // Init stubs
        Repairer repairer = new Repairer();
        repairer.setAvailable(RepairerUtil.AVAILABLE);

        // Init expected results;
        boolean expResult = true;

        // Test results
        boolean result = repairerDao.create(repairer);

        // Verify results
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class RepairerDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");

        // Init stubs
        Repairer repairer = null;

        // Init expected results
        boolean expResult = false;

        // Test
        boolean result = repairerDao.update(repairer);

        // Verify results
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class RepairerDao.
     */
    @Test
    public void testDelete_Repairer() {
        System.out.println("delete");

        // Init stubs
        Repairer repairer = null;

        // Init expected results
        boolean expResult = false;

        // Test
        boolean result = repairerDao.delete(repairer);

        // Verify results
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class RepairerDao.
     */
    @Test
    public void testDelete_int() {
        System.out.println("delete");

        // Init stubs
        int id = 0;

        // Init expected results
        boolean expResult = false;

        // Test
        boolean result = repairerDao.delete(id);

        // Verify results
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class RepairerDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");

        // Init stubs
        int id = 0;

        // Init expected results
        Repairer expResult = null;

        // Test
        Repairer result = repairerDao.getById(id);

        // Verify results
        assertEquals(expResult, result);
    }
}
