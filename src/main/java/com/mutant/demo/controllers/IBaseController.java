package com.mutant.demo.controllers;

import com.mutant.demo.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

public interface IBaseController<E extends Base, ID extends Serializable>{

    public ResponseEntity<?> saveAndCheck(@PathVariable E entity);

    public ResponseEntity<?> getAllHumans();

    public ResponseEntity<?> getOneHuman(@PathVariable ID id);
}
