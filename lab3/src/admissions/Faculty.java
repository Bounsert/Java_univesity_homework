package admissions;

public class Faculty {
    private String name;
    private int passingScore;

    public Faculty(String name, int passingScore) {
        this.name = name;
        this.passingScore = passingScore;
    }
    public boolean isAdmitted(int totalScore) {
        return totalScore >= passingScore;
    }
    public String getName() {
        return name;
    }
}