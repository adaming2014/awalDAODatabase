/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.dao.test;

import fr.adaming.awal.dao.ClientDao;
import fr.adaming.awal.entity.Address;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.User;

/**
 *
 * @author INTI0217
 */
public class Main {
        public static void main(String[] args) {
            ClientDao clientDao = new ClientDao();
            for (Client client : clientDao.getAll()) {
                System.out.println(client.getNumbercard());
            }
            
//            clientDao.create(new Client(null,new User("lucas", "antoine", "lucas.antoine@gmail.com", "123456"), new Address(null,"nantes", "1,rue de gigant", "44100"), "123456"));
        }
}
