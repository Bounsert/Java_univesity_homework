package com.university.admission.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // Назва факультету

    private int budgetPlaces; // Кількість бюджетних місць
    private int contractPlaces; // Кількість контрактних місць

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Applicant> applicants;

    // Порожній конструктор
    public Faculty() {
    }

    public Faculty(String name, int budgetPlaces, int contractPlaces) {
        this.name = name;
        this.budgetPlaces = budgetPlaces;
        this.contractPlaces = contractPlaces;
    }

    // --- Геттери та Сеттери ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getBudgetPlaces() { return budgetPlaces; }
    public void setBudgetPlaces(int budgetPlaces) { this.budgetPlaces = budgetPlaces; }

    public int getContractPlaces() { return contractPlaces; }
    public void setContractPlaces(int contractPlaces) { this.contractPlaces = contractPlaces; }

    public List<Applicant> getApplicants() { return applicants; }
    public void setApplicants(List<Applicant> applicants) { this.applicants = applicants; }
}