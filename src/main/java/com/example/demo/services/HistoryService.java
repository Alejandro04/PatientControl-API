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

    public HistoryService(HistoryRepository historyRepository){
        this.historyRepository = historyRepository;
    }

    public History saveHistory(History history){
        return this.historyRepository.save(history);
   }
}
