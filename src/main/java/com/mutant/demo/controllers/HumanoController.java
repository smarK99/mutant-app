package com.mutant.demo.controllers;

import com.mutant.demo.dtos.StatsDto;
import com.mutant.demo.entities.Humano;
import com.mutant.demo.services.HumanoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/humanos")
public class HumanoController extends BaseControllerImpl<Humano, HumanoServiceImpl> implements IHumanoController{

    @PostMapping("/ismutant")
    public ResponseEntity<?> saveAndCheck(@RequestBody Humano humano){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.saveAndCheck(humano));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<StatsDto> getStats() {
            return ResponseEntity.status(HttpStatus.OK).body(service.getStats());
    }


}
