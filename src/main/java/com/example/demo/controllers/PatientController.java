package com.example.demo.controllers;

import com.example.demo.persistence.entities.Patient;
import com.example.demo.services.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public Page<Patient> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy){
        return this.patientService.findAll(page, size, sortBy);
    }

    @GetMapping("/patients/filter")
    public Page<Patient> findPatientsByFilter(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam String filterCriteria) {
        return patientService.findPatientsByFilter(page, size, sortBy, filterCriteria);
    }

    @GetMapping("/patient/{id}")
    public Optional<Patient> findById(@PathVariable(value = "id") Long id){
        return this.patientService.findById(id);
    }

    @PostMapping("/patients")
    public ResponseEntity<?> createPatient(@RequestBody Patient patient){
        return this.patientService.createPatient(patient);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient) {
        return this.patientService.updatePatient(id, patient);
    }
}
