package admissions;

import java.util.HashMap;
import java.util.Map;

public class AdmissionFacade {

    private Map<String, Faculty> faculties = new HashMap<>();
    private AdmissionRegister register = new AdmissionRegister();
    public AdmissionFacade() {
        // Ініціалізація фіксованого набору факультетів
        faculties.put("ІІТЕ", new Faculty("Інститут інформаціїйних технологій в економіці", 180));
        faculties.put("ЮІ", new Faculty("Юридичний інститут", 180));
        faculties.put("ФІСІТ", new Faculty("Фісіт", 160));
    }

    public void processApplication(Applicant applicant, String facultyKey) {
        System.out.println("Обробка заявки абітурієнта: " + applicant.getName());
        Faculty targetFaculty = faculties.get(facultyKey);

        if (targetFaculty == null) {
            System.out.println("Помилка: Факультет '" + facultyKey + "' не знайдено.");
            return;
        }
        int totalScore = applicant.calculateTotalScore();
        System.out.println("Сумарний бал: " + totalScore);

        if (targetFaculty.isAdmitted(totalScore)) {
            register.recordAdmission(targetFaculty, applicant);
        } else {
            System.out.println("-> Відмова: " + applicant.getName() + " не набирає достатньо балів для " + targetFaculty.getName());
        }
        System.out.println("---------------------------------------");
    }

    public void showFinalResults() {
        register.printRegister();
    }
}