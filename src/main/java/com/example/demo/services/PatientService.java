package com.example.demo.services;

import com.example.demo.persistence.entities.Patient;
import com.example.demo.persistence.repositories.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<Patient> findAll(){
        return new ResponseEntity<>(this.patientRepository.findAll(), HttpStatus.OK).getBody();
    }

    public Patient createPatient(Patient patient){
        return new ResponseEntity<>(this.patientRepository.save(patient), HttpStatus.OK).getBody();
    }

    public Patient updatePatient(Long id, Patient patient){
        Optional<Patient> patientData = this.patientRepository.findById(id);

        if (patientData.isPresent()) {
            Patient _patient = patientData.get();
            _patient.setFirst_name(patient.getFirst_name());
            _patient.setLast_name(patient.getLast_name());
            _patient.setAge(patient.getAge());
            _patient.setPhone(patient.getPhone());
            return new ResponseEntity<>(this.patientRepository.save(_patient), HttpStatus.OK).getBody();
        } else {
            return (Patient) new ResponseEntity<>(HttpStatus.NOT_FOUND).getBody();
        }
    }
}
