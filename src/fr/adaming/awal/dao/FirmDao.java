/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.entity.Firm;

/**
 *
 * @author INTI0217
 */
public class FirmDao extends Dao<Firm> {

    public FirmDao() {
        super(Firm.class);
    }
    
}
