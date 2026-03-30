package admissions;

public class Main {
    public static void main(String[] args) {
        AdmissionFacade committee = new AdmissionFacade();

        // Створення абітурієнтів
        Applicant a1 = new Applicant("Іваненко Даня");
        a1.addGrade("Математика", 100);
        a1.addGrade("Фізика", 90);

        Applicant a2 = new Applicant("Ющенко Петро");
        a2.addGrade("Математика", 60);
        a2.addGrade("Фізика", 80);

        Applicant a3 = new Applicant("Сидоренко Анна");
        a3.addGrade("Економіка", 95);
        a3.addGrade("Англійська", 90);

        // Реєстрація через Фасад
        committee.processApplication(a1, "ЮІ");
        committee.processApplication(a2, "ІІТЕ");
        committee.processApplication(a3, "ФІСІТ");

        // Виведення результатів
        committee.showFinalResults();
    }
}