package unit3.homework;

import java.util.Date;
import java.util.List;

public class Statement {
    private long id;
    private Date creationDate;
    private Administrator administrator;
    private Faculty faculty;
    private List<Applicant> applicants;

    public Statement() {
    }

    public Statement(long id, Date creationDate, Administrator administrator, Faculty faculty, List<Applicant> applicants) {
        this.id = id;
        this.creationDate = creationDate;
        this.administrator = administrator;
        this.faculty = faculty;
        this.applicants = applicants;
    }

    // Метод, який формує відомість та зараховує абітурієнтів
    public void processAdmission() {
        // Сортуємо абітурієнтів за сумою балів (від найбільшого до найменшого)
        applicants.sort((a1, a2) -> Integer.compare(a2.getTotalScore(), a1.getTotalScore()));

        int spots = faculty.getAvailableSpots();

        for (int i = 0; i < applicants.size(); i++) {
            if (i < spots) {
                applicants.get(i).setAdmitted(true);
            } else {
                applicants.get(i).setAdmitted(false);
            }
        }
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public Administrator getAdministrator() { return administrator; }
    public void setAdministrator(Administrator administrator) { this.administrator = administrator; }

    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    public List<Applicant> getApplicants() { return applicants; }
    public void setApplicants(List<Applicant> applicants) { this.applicants = applicants; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Statement{id=").append(id)
                .append(", date=").append(creationDate)
                .append(", admin=").append(administrator.getName())
                .append(", faculty=").append(faculty.getName())
                .append("}\n");

        for (Applicant applicant : applicants) {
            sb.append(" - ").append(applicant.toString()).append("\n");
        }
        return sb.toString();
    }
}