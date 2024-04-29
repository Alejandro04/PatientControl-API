package com.example.demo.controllers;

import com.example.demo.persistence.entities.Patient;
import com.example.demo.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> findAll(){
        return this.patientService.findAll();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        return this.patientService.createPatient(patient);
    }

    @PutMapping("/tutorials/{id}")
    public Patient updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient) {
        return this.patientService.updatePatient(id, patient);
    }

}
