package com.university.admission.controller;

import com.university.admission.entity.Applicant;
import com.university.admission.entity.Faculty;
import com.university.admission.repository.ApplicantRepository;
import com.university.admission.repository.FacultyRepository;
import com.university.admission.service.AdmissionService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdmissionController {

    private final AdmissionService admissionService;
    private final FacultyRepository facultyRepository;
    private final ApplicantRepository applicantRepository;

    @Autowired
    public AdmissionController(AdmissionService admissionService, FacultyRepository facultyRepository, ApplicantRepository applicantRepository) {
        this.admissionService = admissionService;
        this.facultyRepository = facultyRepository;
        this.applicantRepository = applicantRepository;
    }

    // Автоматично додаємо пару факультетів при запуску
    @PostConstruct
    public void initFaculties() {
        if (facultyRepository.count() == 0) {
            facultyRepository.save(new Faculty("Комп'ютерні науки", 2, 5));
            facultyRepository.save(new Faculty("Економіка", 1, 3));
        }
    }

    // Відкриття головної сторінки
    @GetMapping("/")
    public String showMainPage(Model model) {
        model.addAttribute("faculties", facultyRepository.findAll());
        model.addAttribute("applicants", applicantRepository.findAll());
        return "index";
    }

    // Реєстрація нового абітурієнта
    @PostMapping("/register")
    public String registerApplicant(@RequestParam String fullName,
                                    @RequestParam Long facultyId,
                                    @RequestParam int mathGrade,
                                    @RequestParam int ukrainianGrade,
                                    @RequestParam int englishGrade) {

        // ДЕБАГ: Перевіряємо в консолі IDEA, який ID прийшов з сайту
        System.out.println("DEBUG: Прийшов запит на реєстрацію. ID факультету = " + facultyId);

        Applicant newApplicant = new Applicant(fullName, mathGrade, ukrainianGrade, englishGrade);
        admissionService.registerApplicant(newApplicant, facultyId);

        return "redirect:/";
    }

    // Запуск процесу зарахування
    @PostMapping("/process")
    public String processAdmission(@RequestParam Long facultyId) {
        admissionService.processAdmissionForFaculty(facultyId);
        return "redirect:/";
    }
}