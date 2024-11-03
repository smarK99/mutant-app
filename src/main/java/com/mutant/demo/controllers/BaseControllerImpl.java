package com.mutant.demo.controllers;

import com.mutant.demo.entities.Base;
import com.mutant.demo.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E,Long>> implements IBaseController<E,Long> {

    @Autowired
    protected S service;

//    @PostMapping("")
//    public ResponseEntity<?> save(@RequestBody E entity) {
//        try{
//            return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
//        }
//        catch (Exception e){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
//        }
//    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try{
            return ResponseEntity.status(HttpStatus.OK).
                    body(service.findAll());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getOne(@PathVariable Long id) {
//        try{
//            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
//        }
//        catch (Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
//        }
//    }
}
