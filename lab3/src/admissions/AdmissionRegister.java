package admissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdmissionRegister {
    private Map<Faculty, List<Applicant>> admittedStudents = new HashMap<>();

    public void recordAdmission(Faculty faculty, Applicant applicant) {
        admittedStudents.putIfAbsent(faculty, new ArrayList<>());
        admittedStudents.get(faculty).add(applicant);
        System.out.println("-> " + applicant.getName() + " успішно ЗАРАХОВАНИЙ до відомості факультету " + faculty.getName());
    }

    public void printRegister() {
        System.out.println("\n--- ВІДОМІСТЬ ЗАРАХОВАНИХ ---");
        for (Map.Entry<Faculty, List<Applicant>> entry : admittedStudents.entrySet()) {
            System.out.println("Факультет: " + entry.getKey().getName());
            for (Applicant app : entry.getValue()) {
                System.out.println(" - " + app.getName() + " (Сума балів: " + app.calculateTotalScore() + ")");
            }
        }
    }
}