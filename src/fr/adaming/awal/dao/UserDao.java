/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IUserDao;
import fr.adaming.awal.entity.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author INTI0219
 */
public class UserDao extends Dao<User> implements IUserDao {

    public UserDao() {
        super(User.class);
    }

    @Override
    public User getByEmail(final String email) {
        Session session = HibernateUtil.currentSession();
        return (User) session.createCriteria(User.class).add(Restrictions.eq("mail", email)).uniqueResult();
    }
}
