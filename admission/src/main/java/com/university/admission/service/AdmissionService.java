package com.university.admission.service;

import com.university.admission.entity.Applicant;
import com.university.admission.entity.Faculty;
import com.university.admission.repository.ApplicantRepository;
import com.university.admission.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdmissionService {

    private final ApplicantRepository applicantRepository;
    private final FacultyRepository facultyRepository;
    private final ScoreCalculationStrategy scoreStrategy; // Наш патерн Strategy

    @Autowired
    public AdmissionService(ApplicantRepository applicantRepository,
                            FacultyRepository facultyRepository,
                            ScoreCalculationStrategy scoreStrategy) {
        this.applicantRepository = applicantRepository;
        this.facultyRepository = facultyRepository;
        this.scoreStrategy = scoreStrategy;
    }

    // 1. Реєстрація нового абітурієнта
    @Transactional
    public void registerApplicant(Applicant applicant, Long facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new IllegalArgumentException("Факультет не знайдено"));

        applicant.setFaculty(faculty);

        // Використовуємо патерн Стратегія для підрахунку балів
        double totalScore = scoreStrategy.calculateScore(applicant);
        applicant.setTotalScore(totalScore);

        applicant.setAdmissionStatus("Очікує"); // Початковий статус

        applicantRepository.save(applicant);
    }

    // 2. Головна бізнес-логіка: Підведення підсумків та розподіл місць
    @Transactional
    public void processAdmissionForFaculty(Long facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new IllegalArgumentException("Факультет не знайдено"));

        // Дістаємо всіх, хто подав заяви на цей факультет
        List<Applicant> applicants = applicantRepository.findByFacultyId(facultyId);

        // Сортуємо списки: від найвищого балу до найнижчого
        applicants.sort((a1, a2) -> Double.compare(a2.getTotalScore(), a1.getTotalScore()));

        int budgetPlaces = faculty.getBudgetPlaces();
        int contractPlaces = faculty.getContractPlaces();

        // Розподіляємо місця
        for (Applicant applicant : applicants) {
            if (budgetPlaces > 0) {
                applicant.setAdmissionStatus("Зараховано (Бюджет)");
                budgetPlaces--;
            } else if (contractPlaces > 0) {
                applicant.setAdmissionStatus("Зараховано (Контракт)");
                contractPlaces--;
            } else {
                applicant.setAdmissionStatus("Відмовлено");
            }
            // Зберігаємо оновлений статус у БД
            applicantRepository.save(applicant);
        }
    }

    // Допоміжний метод для отримання всіх факультетів
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
}