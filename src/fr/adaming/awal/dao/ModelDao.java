/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IModelDao;
import fr.adaming.awal.entity.Modele;

/**
 *
 * @author INTI0217
 */
public class ModelDao extends HibernateDao<Modele, Integer> implements IModelDao {

    public ModelDao() {
        super(Modele.class);
    }

}
