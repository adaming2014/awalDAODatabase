/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IModelPackageDao;
import fr.adaming.awal.entity.Modele;
import fr.adaming.awal.entity.Modelpackage;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author INTI0217
 */
public class ModelPackageDao extends HibernateDao<Modelpackage, Integer> implements IModelPackageDao {

    public ModelPackageDao() {
        super(Modelpackage.class);
    }

    @Override
    public List<Modelpackage> getPackagesByModel(Modele model) {
        return getSession().createCriteria(Modelpackage.class).add(Restrictions.eq("modele", model)).list();
    }

}
