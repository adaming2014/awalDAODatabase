/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IDeviceRepairDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Device;
import fr.adaming.awal.entity.Devicerepair;
import fr.adaming.awal.entity.Modelpackage;
import fr.adaming.awal.entity.Repairer;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author INTI0227
 */
public class DeviceRepairDao extends HibernateDao<Devicerepair, Integer> implements IDeviceRepairDao {

    private static final String REQUEST_DEVICE_REPAIR_BY_CLIENT = "SELECT d FROM Devicerepair as d"
            + " INNER JOIN d.device as e WHERE e.client = :client";

    public DeviceRepairDao() {
        super(Devicerepair.class);
    }

    @Override
    public List<Devicerepair> getDevicesRepairByClient(final Client client) {
        return getSession().createQuery(REQUEST_DEVICE_REPAIR_BY_CLIENT).setParameter("client", client).list();
    }

    @Override
    public List<Devicerepair> getDevicesRepairByRepairer(final Repairer repairer) {
        return getSession().createCriteria(Devicerepair.class).add(Restrictions.eq("repairer", repairer)).list();
    }

    @Override
    public Devicerepair getByDeviceAndPackage(final Device device, final Modelpackage modelPackage) {
        return (Devicerepair) getSession().createCriteria(Devicerepair.class).add(Restrictions.eq("device", device)).add(Restrictions.eq("modelpackage", modelPackage)).uniqueResult();
    }

}
