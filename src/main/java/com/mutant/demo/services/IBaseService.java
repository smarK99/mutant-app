package com.mutant.demo.services;

import com.mutant.demo.entities.Base;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<E extends Base, ID extends Serializable> {

    public E save(E entity) throws Exception;

    public List<E> findAll() throws Exception;

    public E findById(ID id) throws Exception;

}
