/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IResellerDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Reseller;

/**
 *
 * @author INTI0217
 */
public class ResellerDao extends HibernateDao<Reseller, Integer> implements IResellerDao {

        private static final String REQUEST_RESELLER_BY_ID = "SELECT r FROM Reseller as r "+
            "INNER JOIN r.user as u WHERE u.id = :id";

    public ResellerDao() {
        super(Reseller.class);
    }

    @Override
    public Reseller getResellerByUSerId(Integer id) {
        return (Reseller) getSession().createQuery(REQUEST_RESELLER_BY_ID).setInteger("id", id);
    }

}
