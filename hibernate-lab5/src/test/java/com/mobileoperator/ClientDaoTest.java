package com.mobileoperator;

import com.mobileoperator.dao.ClientDao;
import com.mobileoperator.entity.AdditionalService;
import com.mobileoperator.entity.Client;
import com.mobileoperator.entity.ClientDetail;
import com.mobileoperator.entity.Tariff;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClientDaoTest {

    @Test
    public void testSaveAndRetrieveClient() {
        ClientDao clientDao = new ClientDao();

        // 1. Створюємо Тариф
        Tariff tariff = new Tariff("SuperNet Unlim", 350.0);

        // 2. Створюємо Деталі клієнта
        ClientDetail detail = new ClientDetail("KX123456", "м. Київ, просп. Берестейський, 54");

        // 3. Створюємо Послуги
        AdditionalService roaming = new AdditionalService("Роумінг як вдома");
        AdditionalService extraGb = new AdditionalService("Додаткові 10 ГБ");
        List<AdditionalService> services = new ArrayList<>();
        services.add(roaming);
        services.add(extraGb);

        // 4. Створюємо Клієнта і додаємо все йому
        Client client = new Client("Yevhen Gozhenko", "+380501234567");
        client.setTariff(tariff);
        client.setClientDetail(detail);
        client.setServices(services);

        // 5. Зберігаємо в базу
        clientDao.saveClient(client);

        // 6. Витягуємо з бази і перевіряємо (JUnit)
        Client retrievedClient = clientDao.getClient(client.getId());

        assertNotNull(retrievedClient, "Клієнт повинен бути знайдений у базі");
        assertEquals("Yevhen Gozhenko", retrievedClient.getFullName(), "Ім'я повинно співпадати");
        assertEquals("SuperNet Unlim", retrievedClient.getTariff().getName(), "Тариф повинен співпадати");
        assertEquals("KX123456", retrievedClient.getClientDetail().getPassportNumber(), "Паспортні дані повинні співпадати");
    }
}