/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IDeviceDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Device;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author INTI0227
 */
public class DeviceDao extends Dao<Device> implements IDeviceDao {

    private String reqDevicesByClient = "SELECT u FROM Device u WHERE u.client = :client";

    public DeviceDao() {
        super(Device.class);
    }

    @Override
    public List<Device> getDevicesByClient(Client client) {
        List<Device> entites = null;
        Session session = HibernateUtil.currentSession();
//        Query q = session.createQuery(reqDevicesByClient).setParameter("client", client);
        entites = session.createCriteria(Device.class).add(Restrictions.eq("client", client)).list();
//        entites = q.list();
        HibernateUtil.closeSession();
        return entites;
    }

}
