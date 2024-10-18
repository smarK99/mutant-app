package com.mutant.demo.services;

import com.mutant.demo.dtos.StatsDto;
import com.mutant.demo.entities.Humano;

import java.util.List;

public interface IHumanoService extends IBaseService<Humano,Long>{

    public Humano saveAndCheck(Humano humano) throws Exception;
    public StatsDto getStats();
    public boolean checkSquareMatrix(List<String> adn, Humano humano);
    public char[][] fillMatrix(List<String> adn, int n);
    public boolean checkRows(char[][] matrizDna);
    public boolean checkColumns(char[][] matrizDna);
    public boolean checkDiagonal(char[][] matrizDna);

}
