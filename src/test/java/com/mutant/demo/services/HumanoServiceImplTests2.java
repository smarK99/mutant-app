package com.mutant.demo.services;

import com.mutant.demo.entities.Humano;
import com.mutant.demo.repositories.IBaseRepository;
import com.mutant.demo.repositories.IHumanoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HumanoServiceImplTests2 {

    @Mock
    private IHumanoRepository ihumanoRepository;

    @InjectMocks
    private HumanoServiceImpl humanoService;

    private Humano humano;

    private List<Humano> entities;

    @Mock
    private IBaseRepository<Humano,Long> iBaseRepository;

    @BeforeEach
    public void setUp() {
        entities = new ArrayList<>();
        humano = new Humano();
        humano.setDna(Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"));
    }

    @Test
    public void testSaveAndCheck_Mutant() throws Exception {
        // Configurar el comportamiento del mock
        when(ihumanoRepository.save(any(Humano.class))).thenReturn(humano);

        // Llamar al método a probar
        Humano result = humanoService.saveAndCheck(humano);

        // Verificar que el método save fue llamado
        verify(ihumanoRepository, times(1)).save(humano);

        // Verificar que el resultado es el esperado
        assertTrue(result.getIsMutant());
    }

    @Test
    public void testSaveAndCheck_NotMutant() throws Exception {
        // Configurar el comportamiento del mock
        when(ihumanoRepository.save(any(Humano.class))).thenReturn(humano);

        // Modificar el DNA para que no sea mutante
        humano.setDna(Arrays.asList("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"));

        // Llamar al método a probar
        Humano result = humanoService.saveAndCheck(humano);

        // Verificar que el método save fue llamado
        verify(ihumanoRepository, times(1)).save(humano);

        // Verificar que el resultado es el esperado
        assertFalse(result.getIsMutant());
    }

    @Test
    public void testSaveAndCheck_NonSquareMatrix() throws Exception {
        // Configurar el comportamiento del mock
        when(ihumanoRepository.save(any(Humano.class))).thenReturn(humano);

        // Modificar el DNA para que no sea una matriz cuadrada
        humano.setDna(Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA"));

        // Llamar al método a probar
        Humano result = humanoService.saveAndCheck(humano);

        // Verificar que el método save fue llamado
        verify(ihumanoRepository, times(1)).save(humano);

        // Verificar que el resultado es el esperado
        assertFalse(result.getIsMutant());
    }

    @Test
    public void testSaveAndCheck_Exception() {
        // Configurar el comportamiento del mock para lanzar una excepción
        when(ihumanoRepository.save(any(Humano.class))).thenThrow(new RuntimeException("Error saving humano"));

        // Llamar al método a probar y verificar que lanza una excepción
        Exception exception = assertThrows(Exception.class, () -> {
            humanoService.saveAndCheck(humano);
        });

        // Verificar el mensaje de la excepción
        assertEquals("Error saving humano", exception.getMessage());
    }

    //Testeamos el findALL humanos
    @Test
    @Disabled
    public void testFindAll() throws Exception {
        // Configurar el comportamiento del mock
        when(ihumanoRepository.findAll()).thenReturn(entities);

        // Llamar al método a probar
        List<Humano> result = humanoService.findAll();

        // Verificar que el método findAll fue llamado
        verify(ihumanoRepository, times(1)).findAll();

        // Verificar que el resultado es el esperado
        assertEquals(entities, result);
    }

    @Test
    @Disabled
    public void testFindAll_Exception() {
        // Configurar el comportamiento del mock para lanzar una excepción
        when(ihumanoRepository.findAll()).thenThrow(new RuntimeException("Error finding all entities"));

        // Llamar al método a probar y verificar que lanza una excepción
        Exception exception = assertThrows(Exception.class, () -> {
            humanoService.findAll();
        });

        // Verificar el mensaje de la excepción
        assertEquals("Error finding all entities", exception.getMessage());
    }
}
