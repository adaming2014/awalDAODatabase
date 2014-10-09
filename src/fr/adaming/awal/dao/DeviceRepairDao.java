/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IDeviceRepairDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Devicerepair;
import java.util.List;

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
    public List<Devicerepair> getDevicesRepairByClient(Client client) {
        return getSession().createQuery(REQUEST_DEVICE_REPAIR_BY_CLIENT).setParameter("client", client).list();
    }

}
