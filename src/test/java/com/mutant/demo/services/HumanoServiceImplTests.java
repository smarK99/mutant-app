package com.mutant.demo.services;

import com.mutant.demo.dtos.StatsDto;
import com.mutant.demo.entities.Humano;
import com.mutant.demo.repositories.IBaseRepository;
import com.mutant.demo.repositories.IHumanoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class HumanoServiceImplTests {

    @Autowired
    private HumanoServiceImpl humanoService;

    @Mock
    private Humano humano; // Creamos un mock de la clase Humano

    @Mock
    private IHumanoRepository ihumanoRepository;

    void ServicioTest() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    //Testeamos si la matriz es o no cuadrada
    @Test
    void testCheckSquareMatrix_Cuadrada() {
        // Configuración de la lista (matriz cuadrada)
        List<String> adnCuadrada = List.of("ATCG", "GTCA", "TCGA", "CGTA");

        // Llamada al método
        boolean resultado = humanoService.checkSquareMatrix(adnCuadrada, humano);

        // Verificaciones
        assertTrue(resultado); // Verificamos que el resultado sea true para una matriz cuadrada
        verify(humano, never()).setIsMutant(false); // Confirmamos que no se modifica isMutant
    }

    //Testeamos si la matriz es o no cuadrada
    @Test
    void testCheckSquareMatrix_NoCuadrada() {
        // Configuración de la lista (matriz no cuadrada)
        List<String> adnNoCuadrada = List.of("ATC", "GTCA", "TCG", "CGTA");

        // Llamada al método
        boolean resultado = humanoService.checkSquareMatrix(adnNoCuadrada, humano);

        // Verificaciones
        assertFalse(resultado); // Verificamos que el resultado sea false para una matriz no cuadrada
        verify(humano).setIsMutant(false); // Confirmamos que se modificó isMutant a false
    }

    //Testeamos el llenado de la matriz con la lista de strings
    @Test
    void testFillMatrix() {
        // Configura los datos de prueba
        List<String> adn = List.of("ATCG", "GTCA", "TCGA", "CGTA");
        int n = adn.size();

        char[][] resultado = humanoService.fillMatrix(adn, n);

        // Define la matriz esperada
        char[][] matrizEsperada = {
                {'A', 'T', 'C', 'G'},
                {'G', 'T', 'C', 'A'},
                {'T', 'C', 'G', 'A'},
                {'C', 'G', 'T', 'A'}
        };

        // Verifica que el resultado coincide con la matriz esperada
        assertArrayEquals(matrizEsperada, resultado);
    }

    //Testeamos el metodo que detecta adn en filas
    @Test
    void testCheckRowsWithSequence() {
        // Configurar una matriz que contiene una fila con secuencia de 4 caracteres iguales
        char[][] matrizConSecuencia = {
                {'A', 'T', 'C', 'G'},
                {'G', 'G', 'G', 'G'},
                {'T', 'C', 'A', 'T'},
                {'C', 'G', 'T', 'A'}
        };

        // Ejecutar el método
        boolean resultado = humanoService.checkRows(matrizConSecuencia);

        // Verificar que devuelve true cuando hay una secuencia de 4 o más caracteres iguales
        assertTrue(resultado, "Debería retornar true cuando hay una secuencia de 4 o más caracteres iguales en una fila.");
    }

    //Testeamos el metodo que detecta adn en filas
    @Test
    void testCheckRowsWithoutSequence() {
        // Configurar una matriz sin ninguna secuencia de 4 caracteres iguales en ninguna fila
        char[][] matrizSinSecuencia = {
                {'A', 'T', 'C', 'G'},
                {'G', 'T', 'A', 'C'},
                {'T', 'C', 'A', 'T'},
                {'C', 'G', 'T', 'A'}
        };

        // Ejecutar el método
        boolean resultado = humanoService.checkRows(matrizSinSecuencia);

        // Verificar que devuelve false cuando no hay secuencia de 4 caracteres iguales
        assertFalse(resultado, "Debería retornar false cuando no hay una secuencia de 4 caracteres iguales en ninguna fila.");
    }

    //Testeamos el metodo que detecta adn en columnas
    @Test
    void testCheckColumnsWithSequence() {
        // Configurar una matriz que contiene una columna con secuencia de 4 caracteres iguales
        char[][] matrizConSecuencia = {
                {'A', 'T', 'C', 'G'},
                {'A', 'G', 'G', 'T'},
                {'A', 'C', 'G', 'T'},
                {'A', 'G', 'T', 'T'}
        };

        // Ejecutar el método
        boolean resultado = humanoService.checkColumns(matrizConSecuencia);

        // Verificar que devuelve true cuando hay una secuencia de 4 o más caracteres iguales en una columna
        assertTrue(resultado, "Debería retornar true cuando hay una secuencia de 4 o más caracteres iguales en una columna.");
    }

    //Testeamos el metodo que detecta adn en columnas
    @Test
    void testCheckColumnsWithoutSequence() {
        // Configurar una matriz sin ninguna secuencia de 4 caracteres iguales en ninguna columna
        char[][] matrizSinSecuencia = {
                {'A', 'T', 'C', 'G'},
                {'G', 'C', 'A', 'T'},
                {'T', 'G', 'C', 'A'},
                {'C', 'T', 'G', 'A'}
        };

        // Ejecutar el método
        boolean resultado = humanoService.checkColumns(matrizSinSecuencia);

        // Verificar que devuelve false cuando no hay secuencia de 4 caracteres iguales en ninguna columna
        assertFalse(resultado, "Debería retornar false cuando no hay una secuencia de 4 caracteres iguales en ninguna columna.");
    }

    //Testeamos el metodo que detecta adn en diagonal
    @Test
    void testCheckDiagonalWithSequence() {
        // Configurar una matriz que contiene una secuencia de 4 caracteres iguales en la diagonal
        char[][] matrizConSecuencia = {
                {'A', 'T', 'C', 'G'},
                {'G', 'A', 'C', 'T'},
                {'T', 'C', 'A', 'A'},
                {'C', 'G', 'G', 'A'}
        };

        // Cambiar el último carácter para que forme una diagonal de 4 'A'
        matrizConSecuencia[0][0] = 'A';
        matrizConSecuencia[1][1] = 'A';
        matrizConSecuencia[2][2] = 'A';
        matrizConSecuencia[3][3] = 'A';

        // Ejecutar el método
        boolean resultado = humanoService.checkDiagonal(matrizConSecuencia);

        // Verificar que devuelve true cuando hay una secuencia de 4 o más caracteres iguales en la diagonal
        assertTrue(resultado, "Debería retornar true cuando hay una secuencia de 4 o más caracteres iguales en la diagonal.");
    }

    //Testeamos el metodo que detecta adn en diagonal
    @Test
    void testCheckDiagonalWithoutSequence() {
        // Configurar una matriz sin ninguna secuencia de 4 caracteres iguales en la diagonal
        char[][] matrizSinSecuencia = {
                {'A', 'T', 'C', 'G'},
                {'G', 'C', 'A', 'T'},
                {'T', 'G', 'C', 'A'},
                {'C', 'T', 'G', 'A'}
        };

        // Ejecutar el método
        boolean resultado = humanoService.checkDiagonal(matrizSinSecuencia);

        // Verificar que devuelve false cuando no hay secuencia de 4 caracteres iguales en la diagonal
        assertFalse(resultado, "Debería retornar false cuando no hay una secuencia de 4 caracteres iguales en la diagonal.");
    }


}
