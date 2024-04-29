package com.example.demo.persistence.repositories;

import com.example.demo.persistence.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository <History, Long> {
}