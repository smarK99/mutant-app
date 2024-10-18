package com.mutant.demo.controllers;


import com.mutant.demo.dtos.StatsDto;
import com.mutant.demo.entities.Humano;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IHumanoController extends IBaseController<Humano,Long>{

    public ResponseEntity<?> saveAndCheck(@RequestBody Humano humano);

    public ResponseEntity<StatsDto> getStats();
}
