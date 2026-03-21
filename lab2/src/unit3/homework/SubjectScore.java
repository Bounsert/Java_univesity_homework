package unit3.homework;

public class SubjectScore {
    private long id;
    private String subjectName;
    private int score;

    public SubjectScore() {
    }

    public SubjectScore(long id, String subjectName, int score) {
        this.id = id;
        this.subjectName = subjectName;
        this.score = score;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    @Override
    public String toString() {
        return "SubjectScore{" +
                "subjectName='" + subjectName + '\'' +
                ", score=" + score +
                '}';
    }
}