package com.example.demo.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Data
@Entity
@Table(name="patients")
public class Patient {
    @Id
    // If i not use migrations and I created the DB manually, i need to create a sequence with the next query:
    // CREATE SEQUENCE patients_seq
    // With that and the @SequenceGenerator decorator, we will work without problems
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patients_generator")
    @SequenceGenerator(name = "patients_generator", sequenceName = "patients_seq", allocationSize = 1)
    private Long id;
    private String first_name;
    private String last_name;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<History> history;
}
