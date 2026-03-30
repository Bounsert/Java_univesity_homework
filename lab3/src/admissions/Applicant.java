package admissions;

import java.util.HashMap;
import java.util.Map;

public class Applicant {
    private String name;
    private Map<String, Integer> grades;

    public Applicant(String name) {
        this.name = name;
        this.grades = new HashMap<>();
    }
    public void addGrade(String subject, int score) {
        grades.put(subject, score);
    }
    public int calculateTotalScore() {
        return grades.values().stream().mapToInt(Integer::intValue).sum();
    }
    public String getName() {
        return name;
    }
}