package unit3.homework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Створюємо факультет (наприклад, 2 доступних місця)
        Faculty csFaculty = new Faculty(1L, "Комп'ютерні науки", 2);

        // 2. Створюємо адміністратора
        Administrator admin = new Administrator(1L, "Олена Вікторівна");

        // 3. Створюємо бали та абітурієнтів
        List<SubjectScore> scores1 = new ArrayList<>();
        scores1.add(new SubjectScore(1L, "Математика", 195));
        scores1.add(new SubjectScore(2L, "Українська мова", 180));
        scores1.add(new SubjectScore(3L, "Англійська мова", 120));
        Applicant applicant1 = new Applicant(1L, "Грушков Іван", csFaculty, scores1);

        List<SubjectScore> scores2 = new ArrayList<>();
        scores2.add(new SubjectScore(4L, "Математика", 170));
        scores2.add(new SubjectScore(5L, "Українська мова", 160));
        scores2.add(new SubjectScore(6L, "Англійська мова", 175));
        Applicant applicant2 = new Applicant(2L, "Іванов Петро", csFaculty, scores2);

        List<SubjectScore> scores3 = new ArrayList<>();
        scores3.add(new SubjectScore(7L, "Математика", 150));
        scores3.add(new SubjectScore(8L, "Українська мова", 120));
        scores3.add(new SubjectScore(9L, "Англійська мова", 195));
        Applicant applicant3 = new Applicant(3L, "Сидоренко Анна", csFaculty, scores3);

        // 4. Додаємо всіх абітурієнтів до загального списку
        List<Applicant> applicants = new ArrayList<>();
        applicants.add(applicant1);
        applicants.add(applicant2);
        applicants.add(applicant3);

        // 5. Адміністратор створює відомість
        Statement statement = new Statement(1L, new Date(), admin, csFaculty, applicants);

        // 6. Система підраховує бали та визначає зарахованих (сортує і розподіляє 2 місця)
        statement.processAdmission();

        // 7. Виводимо результат
        System.out.println(statement);
    }
}