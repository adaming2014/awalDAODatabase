/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.hibernate.HibernateUtil;
import fr.adaming.awal.dao.interfaces.IClientDao;
import fr.adaming.awal.entity.Client;
import org.hibernate.Session;

/**
 *
 * @author INTI0217
 */
public class ClientDao extends Dao<Client> implements IClientDao {
    
    private String reClientByMail = "SELECT c FROM Client as c"
            + " inner join c.user as u WHERE u.mail = :mail";
    public ClientDao() {
        super(Client.class);
    }

    @Override
    public Client getClientByMail(String mail) {
        Session session = HibernateUtil.currentSession();
        
        Client client = (Client) session.createQuery(reClientByMail).setString("mail", mail).uniqueResult();
        
        HibernateUtil.closeSession();
        return client;
    }
}
