package com.mutant.demo.controllers;

import com.mutant.demo.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface IBaseController<E extends Base, ID extends Serializable>{

//    public ResponseEntity<?> save(@RequestBody E entity);

    public ResponseEntity<?> getAll();

//    public ResponseEntity<?> getOne(@PathVariable ID id);
}
