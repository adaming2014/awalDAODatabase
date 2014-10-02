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
import fr.adaming.awal.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author INTI0217
 */
public class ClientDao extends Dao<Client> implements IClientDao {
    
    private String reqUserByMail = "SELECT u FROM User u WHERE u.mail = :mail";
    private String reqUserInnerClient = "SELECT u FROM Client u WHERE u.user = :user";
    
    public ClientDao() {
        super(Client.class);
    }

    @Override
    public Client getClientByMail(String mail) {
        Session session = HibernateUtil.currentSession();
        Client client = (Client) session.createQuery(reqUserInnerClient).setParameter("user", session.createQuery(reqUserByMail).setString("mail", mail).uniqueResult()).uniqueResult();
        HibernateUtil.closeSession();
        return client;
    }
}
