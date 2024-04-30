package com.example.demo.services;

import com.example.demo.persistence.entities.History;
import com.example.demo.persistence.repositories.HistoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository){
        this.historyRepository = historyRepository;
    }

   public ResponseEntity<History> createHistory(History history){
        History savedHistory = this.historyRepository.save(history);
        return ResponseEntity.ok(savedHistory);
   }
}
