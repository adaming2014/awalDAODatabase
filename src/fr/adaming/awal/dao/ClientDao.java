/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao;

import fr.adaming.awal.dao.generiq.HibernateDao;
import fr.adaming.awal.dao.interfaces.IClientDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Firm;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author INTI0217
 */
public class ClientDao extends HibernateDao<Client, Integer> implements IClientDao {

    private static final String REQUEST_CLIENT_BY_MAIL = "SELECT c FROM Client as c"
            + " INNER JOIN c.user as u WHERE u.mail = :mail";
    private static final String REQUEST_CLIENT_BY_ID = "SELECT c FROM Client as c "
            + "INNER JOIN c.user as u WHERE u.id = :id";

    public ClientDao() {
        super(Client.class);
    }

    @Override
    public Client getClientByMail(final String mail) {
        return (Client) getSession().createQuery(REQUEST_CLIENT_BY_MAIL).setString("mail", mail).uniqueResult();
    }

    @Override
    public Client getClientByUserId(Integer id) {
        return (Client) getSession().createQuery(REQUEST_CLIENT_BY_ID).setInteger("id", id).uniqueResult();
    }

    @Override
    public List<Client> getClientsByFirm(Firm firm) {
        return getSession().createCriteria(Client.class).add(Restrictions.eq("firm", firm)).list();
    }
}
