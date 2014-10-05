/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IDeviceRepairDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Devicerepair;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author INTI0227
 */
public class DeviceRepairDao extends Dao<Devicerepair> implements IDeviceRepairDao {

    private String reqDevicesRepairByClient = "SELECT d FROM Devicerepair as d"
            + " inner join d.device as e WHERE e.client = :client";

    public DeviceRepairDao() {
        super(Devicerepair.class);
    }

    @Override
    public List<Devicerepair> getDevicesRepairByClient(Client client) {
        List<Devicerepair> devicerepairs = null;
        Session session = HibernateUtil.currentSession();
        Query q = session.createQuery(reqDevicesRepairByClient).setParameter("client", client);
        devicerepairs = q.list();
        HibernateUtil.closeSession();
        return devicerepairs;
    }

}
