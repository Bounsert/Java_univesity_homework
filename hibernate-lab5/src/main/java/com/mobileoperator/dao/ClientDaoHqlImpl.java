package com.mobileoperator.dao;

import com.mobileoperator.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDaoHqlImpl implements ClientDaoInterface {

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
            return session.createQuery("FROM Client", Client.class).list();
        }
    }

    @Override
    public List<Client> getClientsByTariff(String tariffName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("FROM Client c WHERE c.tariff.name = :tName", Client.class);
            query.setParameter("tName", tariffName);
            return query.list();
        }
    }
}