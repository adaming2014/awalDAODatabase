/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IDeviceInsuranceDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Deviceinsurance;
import java.util.List;

/**
 *
 * @author INTI0227
 */
public class DeviceinsuranceDao extends HibernateDao<Deviceinsurance, Integer> implements IDeviceInsuranceDao {

    private static final String REQUEST_DEVICE_INSURANCE_BY_CLIENT = "SELECT d FROM Deviceinsurance as d"
            + " INNER JOIN d.device as u WHERE u.client = :client";

    public DeviceinsuranceDao() {
        super(Deviceinsurance.class);
    }

    @Override
    public List<Deviceinsurance> getDevicesInsuranceByClient(Client client) {
        return getSession().createQuery(REQUEST_DEVICE_INSURANCE_BY_CLIENT).setParameter("client", client).list();
    }

}
