/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.interfaces.IDeviceDao;
import fr.adaming.awal.entity.Device;

/**
 *
 * @author INTI0227
 */
public class DeviceDao extends Dao<Device> implements IDeviceDao {

    public DeviceDao() {
        super(Device.class);
    }

}
