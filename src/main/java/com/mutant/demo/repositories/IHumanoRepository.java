package com.mutant.demo.repositories;

import com.mutant.demo.entities.Humano;
import org.springframework.stereotype.Repository;

@Repository
public interface IHumanoRepository extends IBaseRepository<Humano, Long> {


}
