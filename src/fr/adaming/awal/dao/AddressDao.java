/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IAddressDao;
import fr.adaming.awal.entity.Address;

/**
 *
 * @author INTI0217
 */
public class AddressDao extends HibernateDao<Address, Integer> implements IAddressDao {

    public AddressDao() {
        super(Address.class);
    }

}
