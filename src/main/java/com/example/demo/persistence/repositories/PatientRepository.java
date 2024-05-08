package com.example.demo.persistence.repositories;

import com.example.demo.persistence.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository <Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.first_name LIKE %:filterCriteria% or p.last_name LIKE %:filterCriteria%")
    Page<Patient> findByCustomCriteria(String filterCriteria, Pageable pageable);
}