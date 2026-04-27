package com.mobileoperator;

import com.mobileoperator.dao.ClientDaoHqlImpl;
import com.mobileoperator.dao.ClientDaoInterface;
import com.mobileoperator.dao.ClientDaoSqlImpl;
import com.mobileoperator.entity.Client;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lab6QueryTest {

    @Test
    public void testHqlQueries() {
        System.out.println("=== Тестування HQL Запитів ===");
        ClientDaoInterface hqlDao = new ClientDaoHqlImpl();

        List<Client> allClients = hqlDao.getAllClients();
        assertFalse(allClients.isEmpty(), "База не повинна бути порожньою (HQL)");
        System.out.println("HQL знайшов клієнтів: " + allClients.size());

        List<Client> unlimClients = hqlDao.getClientsByTariff("SuperNet Unlim");
        assertFalse(unlimClients.isEmpty(), "Має знайти клієнтів з цим тарифом (HQL)");
        System.out.println("HQL клієнти на 'SuperNet Unlim': " + unlimClients.get(0).getFullName());
    }

    @Test
    public void testSqlQueries() {
        System.out.println("=== Тестування Native SQL Запитів ===");
        ClientDaoInterface sqlDao = new ClientDaoSqlImpl();

        List<Client> allClients = sqlDao.getAllClients();
        assertFalse(allClients.isEmpty(), "База не повинна бути порожньою (SQL)");
        System.out.println("SQL знайшов клієнтів: " + allClients.size());

        List<Client> unlimClients = sqlDao.getClientsByTariff("SuperNet Unlim");
        assertFalse(unlimClients.isEmpty(), "Має знайти клієнтів з цим тарифом (SQL)");
        System.out.println("SQL клієнти на 'SuperNet Unlim': " + unlimClients.get(0).getFullName());
    }
}