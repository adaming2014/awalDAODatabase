/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IRepairerDao;
import fr.adaming.awal.entity.Repairer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author INTI0221
 */
public class RepairerDao implements IRepairerDao {

    Session session = null;
    Transaction transaction = null;

    @Override
    public List<Repairer> getAll() {
        session = HibernateUtil.currentSession();
        return session.createCriteria(Repairer.class).list();
    }

    @Override
    public boolean create(Repairer repairer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Repairer repairer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Repairer repairer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Repairer getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
