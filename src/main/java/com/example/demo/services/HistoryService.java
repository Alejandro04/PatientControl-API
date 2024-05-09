package com.example.demo.services;

import com.example.demo.persistence.entities.History;
import com.example.demo.persistence.entities.Patient;
import com.example.demo.persistence.repositories.HistoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository){
        this.historyRepository = historyRepository;
    }

    public History saveHistory(History history){
        return this.historyRepository.save(history);
   }

    public Page<History> findHistoryByPatientId(int page, int size, String sortBy, Long patientId) {
        Pageable pageable = PageRequest.of(page, size);
        return historyRepository.findByPatientId(patientId, pageable);
    }

}
