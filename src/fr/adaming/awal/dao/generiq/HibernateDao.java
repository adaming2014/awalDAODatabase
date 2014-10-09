/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao.generiq;

import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IDao;
import fr.adaming.awal.entity.interfaces.IEntity;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

/**
 *
 * @author INTI0217
 * @param <T>
 * @param <I>
 */
public class HibernateDao<T extends IEntity<I>, I extends Serializable> implements IDao<T, I> {

    private final Class<T> entityClass;
    private Session session;

    public HibernateDao(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> getAll() {
        return getSession().createCriteria(entityClass).list();
    }

    @Override
    public T makePersistent(final T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void makeTransient(final T entity) {
        getSession().delete(entity);
    }

    @Override
    public T getById(final I id) {
        return (T) getSession().load(entityClass, id);
    }

    @Override
    public List<T> getByExample(final T exampleEntity) {
        return getSession().createCriteria(entityClass).add(Example.create(exampleEntity)).list();
    }

    public Session getSession() {
        if (session == null) {
            return HibernateUtil.getSessionFactory().getCurrentSession();
        }

        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
