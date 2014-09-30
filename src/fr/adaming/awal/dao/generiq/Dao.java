/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao.generiq;

import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IDao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author INTI0217
 */
public class Dao<T> implements IDao<T> {

    private Class<T> entityClass;

    public Dao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> getAll() {
        Session session = null;
        List<T> lists = null;
        session = HibernateUtil.currentSession();
        lists = session.createCriteria(entityClass).list();
        HibernateUtil.closeSession();
        return lists;
    }

    @Override
    public boolean create(T entity) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = null;
        boolean b_create = false;
        try {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            b_create = true;
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        HibernateUtil.closeSession();
        return b_create;
    }

    @Override
    public boolean update(T entity) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = null;
        boolean b_delete = false;
        try {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            b_delete = true;
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        HibernateUtil.closeSession();
        return b_delete;
    }

    @Override
    public boolean delete(T entity) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = null;
        boolean b_delete = false;
        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            b_delete = true;
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        HibernateUtil.closeSession();
        return b_delete;
    }

    @Override
    public boolean delete(int id) {
        return delete(getById(id));
    }

    @Override
    public T getById(int id) {
        Session session = HibernateUtil.currentSession();
        String requete = String.format("FROM %s WHERE %s = :id",
                entityClass.getSimpleName(),
                "id" + entityClass.getSimpleName());
        T entity = (T) session.createQuery(requete).setInteger("id", id).uniqueResult();
        HibernateUtil.closeSession();
        return entity;
    }

}
