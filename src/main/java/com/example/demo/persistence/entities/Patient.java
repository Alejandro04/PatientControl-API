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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patients_generator")
    @SequenceGenerator(name = "patients_generator", sequenceName = "patients_id_seq", allocationSize = 1)
    private Long id;
    private String first_name;
    private String last_name;
    private int age;
    private String phone;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<History> history;
}
