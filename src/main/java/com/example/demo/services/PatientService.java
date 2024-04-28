package com.example.demo.services;

import com.example.demo.persistence.entities.Patient;
import com.example.demo.persistence.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<Patient> findAll(){
        return this.patientRepository.findAll();
    }

    public Patient createPatient(Patient patient){
        return this.patientRepository.save(patient);
    }
}
