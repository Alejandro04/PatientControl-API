package com.example.demo.services;

import com.example.demo.persistence.entities.History;
import com.example.demo.persistence.repositories.HistoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final EntityManager entityManager;

    public HistoryService(HistoryRepository historyRepository, EntityManager entityManager){
        this.historyRepository = historyRepository;
        this.entityManager = entityManager;
    }


    @Transactional
   public ResponseEntity<History> createHistory(History history){
       String query = "INSERT INTO history (date, reason_consulting, details_consulting, patient_id) " +
               "VALUES (:date, :reason, :details, :patientId)";

       entityManager.createNativeQuery(query)
               .setParameter("date", history.getDate())
               .setParameter("reason", history.getReason_consulting())
               .setParameter("details", history.getDetails_consulting())
               .setParameter("patientId", 1)
               .executeUpdate();

       return ResponseEntity.ok(history);
   }
}
