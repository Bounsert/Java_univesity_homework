package unit3.homework;

import java.util.List;

public class Applicant {
    private long id;
    private String fullName;
    private Faculty faculty;
    private List<SubjectScore> scores;
    private boolean isAdmitted;

    public Applicant() {
    }

    public Applicant(long id, String fullName, Faculty faculty, List<SubjectScore> scores) {
        this.id = id;
        this.fullName = fullName;
        this.faculty = faculty;
        this.scores = scores;
        this.isAdmitted = false; // За замовчуванням не зарахований
    }

    // Метод для підрахунку загальної суми балів
    public int getTotalScore() {
        if (scores == null) return 0;
        int total = 0;
        for (SubjectScore score : scores) {
            total += score.getScore();
        }
        return total;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    public List<SubjectScore> getScores() { return scores; }
    public void setScores(List<SubjectScore> scores) { this.scores = scores; }

    public boolean isAdmitted() { return isAdmitted; }
    public void setAdmitted(boolean admitted) { isAdmitted = admitted; }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", faculty=" + faculty.getName() +
                ", totalScore=" + getTotalScore() +
                ", isAdmitted=" + isAdmitted +
                '}';
    }
}