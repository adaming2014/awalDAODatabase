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

    public RepairerDao() {
        super(Repairer.class);
    }
}
