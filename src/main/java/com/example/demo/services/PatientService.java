package com.example.demo.services;

import com.example.demo.persistence.entities.Patient;
import com.example.demo.persistence.repositories.PatientRepository;
import com.example.demo.utils.PatientValidation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Page<Patient> findAll(int page, int size, String sortBy){
        Sort sort = Sort.by(sortBy).ascending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return this.patientRepository.findAll(pageRequest);
    }

    public Page<Patient> findPatientsByFilter(int page, int size, String sortBy, String filterCriteria) {
        Pageable pageable = PageRequest.of(page, size);
        return patientRepository.findByCustomCriteria(filterCriteria, pageable);
    }

    public ResponseEntity<?> createPatient(Patient patient){
        if(!PatientValidation.isValidPatient(patient)){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The patient info is not valid");
        }

        Patient savedPatient = this.patientRepository.save(patient);
        return ResponseEntity.ok(savedPatient);
    }

    public ResponseEntity<?> updatePatient(Long id, Patient patient){
        Optional<Patient> patientData = this.patientRepository.findById(id);

        if(patientData.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The ID patient is not exist");
        }

        Patient _patient = patientData.get();
        _patient.setFirst_name(patient.getFirst_name());
        _patient.setLast_name(patient.getLast_name());
        _patient.setAge(patient.getAge());
        _patient.setPhone(patient.getPhone());

        Patient savedPatient = this.patientRepository.save(_patient);
        return ResponseEntity.ok(savedPatient);
    }

    public Optional<Patient> findPatientById(Long id){
        return this.patientRepository.findById(id);
    }
}
