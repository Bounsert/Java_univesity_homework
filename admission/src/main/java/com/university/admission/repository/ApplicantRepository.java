package com.university.admission.repository;

import com.university.admission.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    List<Applicant> findByFacultyId(Long facultyId);
}