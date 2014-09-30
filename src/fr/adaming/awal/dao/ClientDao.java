/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.interfaces.IClientDao;
import fr.adaming.awal.entity.Client;
import java.util.List;

/**
 *
 * @author INTI0217
 */
public class ClientDao extends Dao<Client>{  
    public ClientDao() {
        super(Client.class);
    }
}
