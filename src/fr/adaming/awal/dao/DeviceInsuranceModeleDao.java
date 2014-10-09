/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IDeviceInsuranceModeleDao;
import fr.adaming.awal.entity.Deviceinsurancemodel;
import fr.adaming.awal.entity.Modele;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author INTI0227
 */
public class DeviceInsuranceModeleDao extends HibernateDao<Deviceinsurancemodel, Integer>
        implements IDeviceInsuranceModeleDao {

    public DeviceInsuranceModeleDao() {
        super(Deviceinsurancemodel.class);
    }

    @Override
    public List<Deviceinsurancemodel> getDeviceInsuranceModelsByModel(Modele model) {
        return getSession().createCriteria(Deviceinsurancemodel.class).add(Restrictions.eq("modele", model)).list();
    }

}
