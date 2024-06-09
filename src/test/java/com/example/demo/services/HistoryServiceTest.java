package com.example.demo.services;

import com.example.demo.persistence.entities.History;
import com.example.demo.persistence.repositories.HistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HistoryServiceTest {

    @Mock
    private HistoryRepository historyRepository;

    @InjectMocks
    private HistoryService historyService;

    @Test
    void saveHistory() {
        // Arrange
        History history = new History();
        history.setId(1L);
        history.setDetails_consulting("Details");

        when(historyRepository.save(history)).thenReturn(history);

        // Act
        History savedHistory = historyService.saveHistory(history);

        // Assert
        assertEquals(history, savedHistory);
    }

    @Test
    void findHistoryByPatientId() {
        // Arrange
        Long patientId = 1L;
        int page = 0;
        int size = 10;

        List<History> historyList = new ArrayList<>();
        History history1 = new History();
        history1.setId(1L);
        history1.setDetails_consulting("Details history 1");

        History history2 = new History();
        history2.setId(2L);
        history2.setDetails_consulting("Details history 2");

        historyList.add(history1);
        historyList.add(history2);

        Pageable pageable = PageRequest.of(page, size);
        Page<History> expectedPage = new PageImpl<>(historyList, pageable, historyList.size());

        when(historyRepository.findByPatientId(patientId, pageable)).thenReturn(expectedPage);

        // Act
        Page<History> actualPage = historyService.findHistoryByPatientId(page, size, "id", patientId);

        // Assert
        assertEquals(expectedPage, actualPage);
        assertEquals(historyList, actualPage.getContent());
    }
}
