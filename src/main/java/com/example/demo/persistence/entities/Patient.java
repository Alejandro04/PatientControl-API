package com.example.demo.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patients_generator")
    @SequenceGenerator(name = "patients_generator", sequenceName = "patients_id_seq", allocationSize = 1)
    private Long id;
    private String first_name;
    private String last_name;
    private int age;
    private String phone;

    public Patient() {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.phone = phone;
    }
}
