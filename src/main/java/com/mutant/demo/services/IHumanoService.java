package com.mutant.demo.services;

import com.mutant.demo.dtos.StatsDto;
import com.mutant.demo.entities.Humano;

public interface IHumanoService extends IBaseService<Humano,Long>{

    public Humano saveAndCheck(Humano humano) throws Exception;
    public StatsDto getStats();
}
