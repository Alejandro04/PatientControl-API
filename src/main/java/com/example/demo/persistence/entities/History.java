package com.example.demo.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
@Entity
@Setter
@Getter
@Table(name="patients_history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_patients_generator")
    @SequenceGenerator(name = "history_patients_generator", sequenceName = "history_patients_id_seq", allocationSize = 1)
    private Long id;
    private Date date;
    private String reason_consulting;
    private String details_consulting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;
}
