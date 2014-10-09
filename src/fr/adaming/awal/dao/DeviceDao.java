/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IDeviceDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Device;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author INTI0227
 */
public class DeviceDao extends HibernateDao<Device, Integer> implements IDeviceDao {

    public DeviceDao() {
        super(Device.class);
    }

    @Override
    public List<Device> getDevicesByClient(Client client) {
        return getSession().createCriteria(Device.class).add(Restrictions.eq("client", client)).list();
    }

}
