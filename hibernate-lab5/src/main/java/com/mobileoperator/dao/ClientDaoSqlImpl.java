package com.mobileoperator.dao;

import com.mobileoperator.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDaoSqlImpl implements ClientDaoInterface {

    @Override
    public void saveClient(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAllClients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createNativeQuery("SELECT * FROM clients", Client.class).list();
        }
    }

    @Override
    public List<Client> getClientsByTariff(String tariffName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT c.* FROM clients c " +
                    "JOIN tariffs t ON c.tariff_id = t.id " +
                    "WHERE t.name = :tName";
            return session.createNativeQuery(sql, Client.class)
                    .setParameter("tName", tariffName)
                    .list();
        }
    }
}