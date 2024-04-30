package com.example.demo.utils;

import com.example.demo.persistence.entities.Patient;

public class PatientValidation {

    public static boolean isValidPatient(Patient patient) {
        if (patient.getFirst_name() == null || patient.getFirst_name().isEmpty()) {
            return false;
        }
        if (patient.getLast_name() == null || patient.getLast_name().isEmpty()) {
            return false;
        }
        if(patient.getAge() < 0){
           return false;
        }

       return true;
    }
}
