package com.university.admission.service;

import com.university.admission.entity.Applicant;
import org.springframework.stereotype.Component;

@Component
public class StandardScoreStrategy implements ScoreCalculationStrategy {

    @Override
    public double calculateScore(Applicant applicant) {
        // Проста стратегія: сума всіх балів
        return applicant.getMathGrade() + applicant.getUkrainianGrade() + applicant.getEnglishGrade();
    }
}