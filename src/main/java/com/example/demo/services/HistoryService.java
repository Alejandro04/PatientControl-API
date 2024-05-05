package com.example.demo.services;

import com.example.demo.persistence.entities.History;
import com.example.demo.persistence.repositories.HistoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private final EntityManager entityManager;
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository, EntityManager entityManager, HistoryRepository historyRepository1){
        this.entityManager = entityManager;
        this.historyRepository = historyRepository;
    }

    @Transactional
   public ResponseEntity<?> createHistory(History history){
       String query = "INSERT INTO history (date, reason_consulting, details_consulting, patient_id) " +
               "VALUES (:date, :reason, :details, :patient_id)";

       entityManager.createNativeQuery(query)
               .setParameter("date", history.getDate())
               .setParameter("reason", history.getReason_consulting())
               .setParameter("details", history.getDetails_consulting())
               .setParameter("patient_id", 1)
               .executeUpdate();

       return ResponseEntity.ok(history);
   }

   public History saveHistory(History history){
        return this.historyRepository.save(history);
   }
}
