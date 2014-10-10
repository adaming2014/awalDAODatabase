/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IRepairerDao;
import fr.adaming.awal.entity.Repairer;

/**
 *
 * @author INTI0221
 */
public class RepairerDao extends HibernateDao<Repairer, Integer> implements IRepairerDao {

    private static final String REQUEST_REPAIRER_BY_ID = "SELECT r FROM Repairer as r "+
            "INNER JOIN r.user as u WHERE u.id = :id";
    public RepairerDao() {
        super(Repairer.class);
    }

    @Override
    public Repairer getRepairerByUserId(Integer id) {
        return (Repairer)getSession().createQuery(REQUEST_REPAIRER_BY_ID).setInteger("id", id).uniqueResult(); 
    }
}
