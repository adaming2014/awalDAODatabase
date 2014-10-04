/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IModelPackageDao;
import fr.adaming.awal.entity.Modele;
import fr.adaming.awal.entity.Modelpackage;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author INTI0217
 */
public class ModelPackageDao extends Dao<Modelpackage> implements IModelPackageDao {

    private String reqPackageByModel = "SELECT u FROM Modelpackage u WHERE u.modele = :modele";

    public ModelPackageDao() {
        super(Modelpackage.class);
    }

    @Override
    public List<Modelpackage> getPackagesByModel(Modele model) {
        List<Modelpackage> modelpackages = null;
        Session session = HibernateUtil.currentSession();
        Query q = session.createQuery(reqPackageByModel).setParameter("modele", model);
        modelpackages = q.list();
        HibernateUtil.closeSession();
        return modelpackages;
    }

}
