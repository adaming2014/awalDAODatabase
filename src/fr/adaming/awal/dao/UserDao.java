/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.entity.User;

/**
 *
 * @author INTI0219
 */
public class UserDao extends Dao<User>{

    public UserDao(Class<User> entityClass) {
        super(entityClass);
    }

    
}
