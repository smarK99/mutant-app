package com.mutant.demo.controllers;

import com.mutant.demo.entities.Humano;
import com.mutant.demo.services.HumanoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/personas")
public class HumanoController extends BaseControllerImpl<Humano, HumanoServiceImpl>{
    @Override
    public ResponseEntity<?> saveAndCheck(Humano entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllHumans() {
        return null;
    }

    @Override
    public ResponseEntity<?> getOneHuman(Long aLong) {
        return null;
    }
}
