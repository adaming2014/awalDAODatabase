/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.interfaces.IDeviceRepairDao;
import fr.adaming.awal.entity.Devicerepair;

/**
 *
 * @author INTI0227
 */
public class DeviceRepairDao extends Dao<Devicerepair> implements IDeviceRepairDao {

    public DeviceRepairDao() {
        super(Devicerepair.class);
    }

}
