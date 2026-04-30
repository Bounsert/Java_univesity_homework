package com.university.admission;

import com.university.admission.entity.Applicant;
import com.university.admission.service.ScoreCalculationStrategy;
import com.university.admission.service.StandardScoreStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdmissionServiceTest {

    @Test
    public void testScoreCalculation() {
        System.out.println("=== Запуск тесту підрахунку балів ===");

        // Створюємо тестового абітурієнта
        Applicant testApplicant = new Applicant("Тестовий Студент", 180, 190, 175);

        // Викликаємо стратегію підрахунку
        ScoreCalculationStrategy strategy = new StandardScoreStrategy();
        double totalScore = strategy.calculateScore(testApplicant);

        assertEquals(545.0, totalScore, "Система неправильно підрахувала суму балів!");

        System.out.println("Тест пройдено успішно! Сума балів: " + totalScore);
    }
}