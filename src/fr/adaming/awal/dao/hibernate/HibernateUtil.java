/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author INTI0217
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("probleme de configuration" + ex.getMessage());
        }
    }

    private static final ThreadLocal session = new ThreadLocal();

    public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        if (null == s) {
            s = sessionFactory.openSession();
            session.set(s);
        }

        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        if (s != null) {
            s.close();
        }
    }
}
