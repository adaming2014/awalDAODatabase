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
        List<Repairer> repairers = session.createCriteria(Repairer.class).list();
        HibernateUtil.closeSession();

        return repairers;
    }

    @Override
    public boolean create(Repairer repairer) {
        boolean result = true;
        session = HibernateUtil.currentSession();

        try {
            transaction = session.beginTransaction();
            session.save(repairer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            result = false;
        } finally {
            HibernateUtil.closeSession();
        }

        return result;
    }

    @Override
    public boolean update(Repairer repairer) {
        boolean result = true;
        session = HibernateUtil.currentSession();

        try {
            transaction = session.beginTransaction();
            session.update(repairer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            result = false;
        } finally {
            HibernateUtil.closeSession();
        }

        return result;
    }

    @Override
    public boolean delete(Repairer repairer) {
        boolean result = true;
        session = HibernateUtil.currentSession();

        try {
            transaction = session.beginTransaction();
            session.delete(repairer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            result = false;
        } finally {
            HibernateUtil.closeSession();
        }

        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = true;
        session = HibernateUtil.currentSession();

        Repairer repairer = (Repairer) session.load(Repairer.class, id);
        if (repairer == null) {
            return false;
        }

        try {
            transaction = session.beginTransaction();
            session.delete(repairer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            result = false;
        } finally {
            HibernateUtil.closeSession();
        }

        return result;
    }

    @Override
    public Repairer getById(int id) {
        session = HibernateUtil.currentSession();
        Repairer repairer = (Repairer) session.load(Repairer.class, id);
        HibernateUtil.closeSession();

        return repairer;
    }

}
