/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IDeviceInsuranceDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Device;
import fr.adaming.awal.entity.Deviceinsurance;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author INTI0227
 */
public class DeviceinsuranceDao extends Dao<Deviceinsurance> implements IDeviceInsuranceDao {

    private String reqDevicesInsuranceByClient = "SELECT d FROM Deviceinsurance as c"
            + " inner join c.device as u WHERE u.client = :client";

    public DeviceinsuranceDao() {
        super(Deviceinsurance.class);
    }

    @Override
    public List<Deviceinsurance> getDevicesInsuranceByClient(Client client) {
        List<Deviceinsurance> entites = null;
        Session session = HibernateUtil.currentSession();
        Query q = session.createQuery(reqDevicesInsuranceByClient).setParameter("client", client);
        entites = q.list();
        HibernateUtil.closeSession();
        return entites;
    }

}
