/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IResellerDao;
import fr.adaming.awal.entity.Reseller;

/**
 *
 * @author INTI0217
 */
public class ResellerDao extends HibernateDao<Reseller, Integer> implements IResellerDao {

    public ResellerDao() {
        super(Reseller.class);
    }

}
