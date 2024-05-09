package com.example.demo.persistence.repositories;

import com.example.demo.persistence.entities.History;
import com.example.demo.persistence.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HistoryRepository extends JpaRepository <History, Long> {
    @Query("SELECT h FROM History h WHERE h.patient.id = :patientId")
    Page<History> findByPatientId(Long patientId, Pageable pageable);
}