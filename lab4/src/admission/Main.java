package admission;

public class Main {
    public static void main(String[] args) {
        // Мінімальний прохідний бал
        double passingScore = 500.0;

        // Створення першого абітурієнта
        Applicant applicant1 = new Applicant("Іван Грінчевський", "Комп'ютерні науки");
        applicant1.addGrade("Математика", 140);
        applicant1.addGrade("Фізика", 160);
        applicant1.addGrade("Мова", 170);

        // Іван вступає на загальних умовах
        applicant1.setStrategy(new StandardStrategy());

        // Створення другого абітурієнта
        Applicant applicant2 = new Applicant("Олена Петренко", "Комп'ютерні науки");
        applicant2.addGrade("Математика", 175);
        applicant2.addGrade("Фізика", 150);
        applicant2.addGrade("Мова", 165);

        // Олена має пільги
        applicant2.setStrategy(new PrivilegeStrategy());

        // Масив абітурієнтів для формування відомості
        Applicant[] applicants = {applicant1, applicant2};

        System.out.println("--- Відомість Приймальної Комісії ---");
        for (Applicant app : applicants) {
            double score = app.getTotalScore();
            String status = (score >= passingScore) ? "ЗАРАХОВАНО" : "ВІДМОВЛЕНО";

            System.out.printf("Абітурієнт: %s | Факультет: %s | Бали: %.1f | Статус: %s\n",
                    app.getName(), app.getFaculty(), score, status);
        }
    }
}