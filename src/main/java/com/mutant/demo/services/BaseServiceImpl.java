package com.mutant.demo.services;

import com.mutant.demo.entities.Base;
import com.mutant.demo.repositories.IBaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements IBaseService<E,ID> {

    @Autowired
    protected IBaseRepository<E,ID> ibaseRepository;

//    @Transactional
//    @Override
//    public E save(E entity) throws Exception {
//        try {
//            return ibaseRepository.save(entity);
//        }catch (Exception e){
//            throw new Exception(e.getMessage());
//        }
//    }

    @Transactional
    @Override
    public List<E> findAll() throws Exception {
        try {
            return ibaseRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

//    @Transactional
//    @Override
//    public E findById(ID id) throws Exception {
//        try {
//            Optional<E> persona = ibaseRepository.findById(id);
//            return persona.get();
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }

}
