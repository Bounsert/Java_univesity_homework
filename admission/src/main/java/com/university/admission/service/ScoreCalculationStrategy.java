package com.university.admission.service;

import com.university.admission.entity.Applicant;

// Патерн GoF: Strategy
public interface ScoreCalculationStrategy {
    double calculateScore(Applicant applicant);
}