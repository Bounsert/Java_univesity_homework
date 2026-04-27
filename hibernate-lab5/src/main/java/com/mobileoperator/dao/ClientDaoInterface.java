package com.mobileoperator.dao;

import com.mobileoperator.entity.Client;
import java.util.List;

public interface ClientDaoInterface {
    // Збереження клієнта
    void saveClient(Client client);

    // Отримання всіх клієнтів (вибірка)
    List<Client> getAllClients();

    // Пошук клієнтів за назвою їхнього тарифу (вибірка з умовою)
    List<Client> getClientsByTariff(String tariffName);
}