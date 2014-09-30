/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IUserDao;
import fr.adaming.awal.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author INTI0219
 */
public class UserDao implements IUserDao{

    Transaction transaction = null;

    public UserDao() 
    {
        
    }
    
    @Override
    public List<User> getAll() {
        Session session = HibernateUtil.currentSession();
        
        session = HibernateUtil.currentSession();
        List<User> users =  new ArrayList<User>();
        try 
        {
            users = session.createQuery("FROM User").list();
    
            transaction.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            if(null != transaction && transaction.isActive())
            {
                transaction.rollback();
            }
        }    
        HibernateUtil.closeSession();
        return users;
    }

    @Override
    public boolean create(User user) {
        
        Session session = HibernateUtil.currentSession();
        boolean create_ok = false;
        
        try 
        {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            create_ok = true;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            if(null != transaction && transaction.isActive())
            {
                transaction.rollback();
            }
        }
        finally{
            
        HibernateUtil.closeSession();
        return create_ok;
        }
    }

    @Override
    public boolean update(User user) {
        Session session = HibernateUtil.currentSession();
        boolean update_ok = false;

        try 
        {
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            update_ok = true;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            if(null != transaction && transaction.isActive())
            {
                transaction.rollback();
            }
        }
        HibernateUtil.closeSession(); 
        return update_ok;
    }

    @Override
    public boolean delete(User user) {
        Session session = HibernateUtil.currentSession();
        boolean deleteByUser_ok = false;
        
        try 
        {
            transaction = session.beginTransaction();

            session.delete(user);
            transaction.commit();
            deleteByUser_ok = true;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            if(null != transaction && transaction.isActive())
            {
                transaction.rollback();
            }
        }
        HibernateUtil.closeSession();
        return deleteByUser_ok;
    }    

    @Override
    public boolean delete(int id) {
        
        Session session = HibernateUtil.currentSession();
        boolean deleteById_ok = false;

        try 
        {
            transaction = session.beginTransaction();
            String requete = "FROM User WHERE id_user = :id";
            User user = (User)session.createQuery(requete).setParameter("id", id).uniqueResult();
            session.delete(user);
            transaction.commit();
            deleteById_ok = false;

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            if(null != transaction && transaction.isActive())
            {
                transaction.rollback();
            }
        }
        HibernateUtil.closeSession();
        return deleteById_ok;
    }    

    @Override
    public User getById(int id) {
        
        Session session = HibernateUtil.currentSession();
        User user = new User();
        
        try 
        {
            transaction = session.beginTransaction();
            String requete = "FROM User WHERE id_user = :id";
            user = (User)session.createQuery(requete).setParameter("id", id).uniqueResult();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            if(null != transaction && transaction.isActive())
            {
                transaction.rollback();
            }
        }    
        HibernateUtil.closeSession(); 
        return user;
    }
    
}
