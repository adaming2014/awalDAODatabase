/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IDeviceInsuranceModeleDao;
import fr.adaming.awal.entity.Deviceinsurancemodel;
import fr.adaming.awal.entity.Modele;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author INTI0227
 */
public class DeviceInsuranceModeleDao extends Dao<Deviceinsurancemodel>
        implements IDeviceInsuranceModeleDao {

    private String reqDeviceInsuranceByModel = "SELECT d FROM Deviceinsurancemodel d WHERE d.modele = :modele";

    public DeviceInsuranceModeleDao() {
        super(Deviceinsurancemodel.class);
    }

    @Override
    public List<Deviceinsurancemodel> getDeviceInsuranceModelsByModel(Modele model) {
        List<Deviceinsurancemodel> deviceinsurancemodels = null;
        Session session = HibernateUtil.currentSession();
        Query q = session.createQuery(reqDeviceInsuranceByModel).setParameter("modele", model);
        deviceinsurancemodels = q.list();
        HibernateUtil.closeSession();
        return deviceinsurancemodels;
    }

}
