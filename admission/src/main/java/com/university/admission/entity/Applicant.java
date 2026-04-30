package com.university.admission.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "applicants")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName; // ПІБ абітурієнта

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty; // На який факультет подає заяву

    private int mathGrade; // Бал з математики
    private int ukrainianGrade; // Бал з української мови
    private int englishGrade; // Бал з англійської мови

    private double totalScore; // Загальний підрахований бал

    private String admissionStatus; // Статус: "Очікує", "Зараховано (Бюджет)", "Зараховано (Контракт)", "Відмовлено"

    // Порожній конструктор
    public Applicant() {
    }

    public Applicant(String fullName, int mathGrade, int ukrainianGrade, int englishGrade) {
        this.fullName = fullName;
        this.mathGrade = mathGrade;
        this.ukrainianGrade = ukrainianGrade;
        this.englishGrade = englishGrade;
        this.admissionStatus = "Очікує"; // Стандартний статус при реєстрації
    }

    // --- Геттери та Сеттери ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    public int getMathGrade() { return mathGrade; }
    public void setMathGrade(int mathGrade) { this.mathGrade = mathGrade; }

    public int getUkrainianGrade() { return ukrainianGrade; }
    public void setUkrainianGrade(int ukrainianGrade) { this.ukrainianGrade = ukrainianGrade; }

    public int getEnglishGrade() { return englishGrade; }
    public void setEnglishGrade(int englishGrade) { this.englishGrade = englishGrade; }

    public double getTotalScore() { return totalScore; }
    public void setTotalScore(double totalScore) { this.totalScore = totalScore; }

    public String getAdmissionStatus() { return admissionStatus; }
    public void setAdmissionStatus(String admissionStatus) { this.admissionStatus = admissionStatus; }
}