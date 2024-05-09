package com.example.demo.controllers;

import com.example.demo.persistence.entities.History;
import com.example.demo.persistence.entities.Patient;
import com.example.demo.services.HistoryService;
import com.example.demo.services.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class HistoryController {
  private final HistoryService historyService;
  private final PatientService patientService;

  public HistoryController(HistoryService historyService, PatientService patientService){
      this.historyService = historyService;
      this.patientService = patientService;
  }

  @GetMapping("/{patientId}/history")
  public Page<History> findPatientsByFilter(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "id") String sortBy,
          @PathVariable(value = "patientId") Long patientId) {
    return historyService.findHistoryByFilter(page, size, sortBy, patientId);
  }

  @PostMapping("/{patientId}/history")
  public ResponseEntity<?> createHistory(@PathVariable(value = "patientId") Long patientId, @RequestBody History history) {
    this.patientService.findPatientById(patientId).map(patient -> {
      history.setPatient(patient);
      return historyService.saveHistory(history);
    });

    return new ResponseEntity<>(history, HttpStatus.CREATED);
  }
}
