/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IAdminDao;
import fr.adaming.awal.entity.Admin;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author INTI0227
 */
public class AdminDao extends HibernateDao<Admin, Integer> implements IAdminDao {

    private static final String REQUEST_ADMIN_BY_ID = "SELECT a FROM Admin as a "+
            "INNER JOIN a.user as u WHERE u.id = :id";
    public AdminDao() {
        super(Admin.class);
    }

    @Override
    public Admin getAdminByUserId(Integer id) {
        //getSession().createCriteria(Admin.class).add(Restrictions.eq("user", user)).uniqueResult();
        return (Admin)getSession().createQuery(REQUEST_ADMIN_BY_ID).setInteger("id", id).uniqueResult();
    }
}
