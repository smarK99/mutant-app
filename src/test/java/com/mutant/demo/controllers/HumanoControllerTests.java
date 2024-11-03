//package com.mutant.demo.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mutant.demo.dtos.StatsDto;
//import com.mutant.demo.entities.Humano;
//import com.mutant.demo.services.HumanoServiceImpl;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(HumanoController.class)
//public class HumanoControllerTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private HumanoServiceImpl humanoService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    @Disabled
//    public void testSaveAndCheck_isMutant() throws Exception {
//        // Configuración del humano y respuesta esperada
//        Humano humano = new Humano();
//        humano.setDna(List.of("ATGC", "CAGT", "TTAT", "AGAA"));
//        humano.setIsMutant(true);
//
//        when(humanoService.saveAndCheck(Mockito.any(Humano.class))).thenReturn(humano);
//
//        // Ejecución de la prueba
//        mockMvc.perform(post("/ismutant")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(humano)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.isMutant").value(true));
//    }
//
//    @Test
//    @Disabled
//    public void testSaveAndCheck_invalidRequest() throws Exception {
//        // Configurar el servicio para lanzar una excepción
//        when(humanoService.saveAndCheck(Mockito.any(Humano.class))).thenThrow(new Exception("Error"));
//
//        // Ejecución de la prueba con manejo de error
//        mockMvc.perform(post("/ismutant")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(new Humano())))
//                .andExpect(status().isBadRequest())
//                .andExpect(content().string("{\"error\":\"Error, por favor intente más tarde\"}"));
//    }
//
//    @Test
//    @Disabled
//    public void testGetStats() throws Exception {
//        // Configuración del objeto StatsDto de respuesta esperada
//        StatsDto statsDto = StatsDto.builder()
//                .count_human_dna(100)
//                .count_mutant_dna(40)
//                .ratio(0.4f)
//                .build();
//
//        when(humanoService.getStats()).thenReturn(statsDto);
//
//        // Ejecución de la prueba
//        mockMvc.perform(get("/stats")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.count_human_dna").value(100))
//                .andExpect(jsonPath("$.count_mutant_dna").value(40))
//                .andExpect(jsonPath("$.ratio").value(0.4));
//    }
//}

