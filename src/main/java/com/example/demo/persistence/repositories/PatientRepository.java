package com.example.demo.persistence.repositories;

import com.example.demo.persistence.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient, Long> {
}