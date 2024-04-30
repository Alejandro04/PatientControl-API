package com.example.demo.controllers;

import com.example.demo.persistence.entities.History;
import com.example.demo.services.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
public class HistoryController {
  private final HistoryService historyService;

  public HistoryController(HistoryService historyService){
      this.historyService = historyService;
  }

  @PostMapping
  public ResponseEntity<History> createHistory(@RequestBody History history){
    return this.historyService.createHistory(history);
  }
}
