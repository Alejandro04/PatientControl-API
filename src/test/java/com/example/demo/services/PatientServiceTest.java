package com.example.demo.services;

import com.example.demo.persistence.entities.Patient;
import com.example.demo.persistence.repositories.PatientRepository;
import com.example.demo.utils.PatientValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientValidation patientValidation;

    @InjectMocks
    private PatientService patientService;

    @Test
    void findAll() {
        // Arrange
        int page = 0;
        int size = 10;
        String sortBy = "name";

        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient("John Doe"));
        patientList.add(new Patient("Jane Doe"));

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<Patient> expectedPage = new PageImpl<>(patientList, pageRequest, patientList.size());

        when(patientRepository.findAll(pageRequest)).thenReturn(expectedPage);

        // Act
        Page<Patient> actualPage = patientService.findAll(page, size, sortBy);

        // Assert
        assertEquals(expectedPage, actualPage);
        assertEquals(patientList, actualPage.getContent());
    }

    @Test
    void findById() {
        // Arrange
        Long patientId = 1L;
        Patient expectedPatient = new Patient();
        expectedPatient.setId(patientId);
        expectedPatient.setFirst_name("John Doe");
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(expectedPatient));

        // Act
        Optional<Patient> actualPatient = patientService.findById(patientId);

        // Assert
        assertEquals(Optional.of(expectedPatient), actualPatient);
    }

    @Test
    void findPatientById() {
        // Arrange
        Long patientId = 1L;
        Patient expectedPatient = new Patient();
        expectedPatient.setId(patientId);
        expectedPatient.setFirst_name("John Doe");

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(expectedPatient));

        // Act
        Optional<Patient> actualPatient = patientService.findPatientById(patientId);

        // Assert
        assertEquals(Optional.of(expectedPatient), actualPatient);
    }
}