package com.mutant.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.mutant.demo.dtos.StatsDto;
import com.mutant.demo.entities.Humano;
import com.mutant.demo.repositories.IHumanoRepository;
import com.mutant.demo.services.HumanoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class StatsTests {

    @InjectMocks
    private HumanoServiceImpl humanoService;

    @Mock
    private IHumanoRepository ihumanoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStats() {
        // Dado
        Humano humano1 = new Humano();
        humano1.setIsMutant(true);

        Humano humano2 = new Humano();
        humano2.setIsMutant(false);

        Humano humano3 = new Humano();
        humano3.setIsMutant(true);

        List<Humano> mockHumanos = Arrays.asList(humano1, humano2, humano3);
        when(ihumanoRepository.findAll()).thenReturn(mockHumanos);

        // Método a testear
        StatsDto stats = humanoService.getStats();

        // Entonces
        assertEquals(1, stats.getCount_human_dna());
        assertEquals(2, stats.getCount_mutant_dna());
        assertEquals(2.0 / 3.0, stats.getRatio(), 0.001);
    }

    @Test
    @Disabled
    void testGetStats_NoHumans() {
        // Dado
        when(ihumanoRepository.findAll()).thenReturn(Arrays.asList());

        // Método a testear
        StatsDto stats = humanoService.getStats();

        // Entonces
        assertEquals(0, stats.getCount_human_dna());
        assertEquals(0, stats.getCount_mutant_dna());
        assertEquals(0, stats.getRatio(), 0.001);
    }
}

