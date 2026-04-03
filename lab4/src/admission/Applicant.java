package admission;

import java.util.HashMap;
import java.util.Map;

public class Applicant {
    private String name;
    private String faculty;
    private Map<String, Integer> grades;
    private CalculationStrategy strategy;

    public Applicant(String name, String faculty) {
        this.name = name;
        this.faculty = faculty;
        this.grades = new HashMap<>();
    }
    public void addGrade(String subject, int score) {
        grades.put(subject, score);
    }
    public void setStrategy(CalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double getTotalScore() {
        if (strategy == null) {
            throw new IllegalStateException("Стратегію підрахунку не встановлено!");
        }
        return strategy.calculateTotalScore(grades);
    }
    public String getName() {
        return name;
    }
    public String getFaculty() {
        return faculty;
    }
}