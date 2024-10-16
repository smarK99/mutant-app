package com.mutant.demo.services;

import com.mutant.demo.entities.Humano;
import com.mutant.demo.repositories.IHumanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanoServiceImpl extends BaseServiceImpl<Humano,Long> implements IHumanoService{

    @Autowired
    private IHumanoRepository ihumanoRepository;

    @Override
    public Humano saveAndCheck(Humano humano) throws Exception {
        try {
            List<String> dna = humano.getDna();
            int n = dna.get(0).length();
            char[][] matrizDna = new char[n][n];

            for (String row : dna) {
                for (int i = 0; i < n; i++) {

                }
            }


            ihumanoRepository.save(humano);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return null;
    }
}
