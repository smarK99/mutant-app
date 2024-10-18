package com.mutant.demo.services;

import com.mutant.demo.dtos.StatsDto;
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
        try{
            List<String> dna = humano.getDna();
            int n = dna.size();

            if (humano.checkSquareMatrix(dna)) {
                char[][] matrizDna = humano.fillMatrix(dna,n);
                if (humano.checkRows(matrizDna) || humano.checkColumns(matrizDna) || humano.checkDiagonal(matrizDna)) {
                    System.out.println("ES MUTANTE!!");
                    humano.setIsMutant(true);
                    return ihumanoRepository.save(humano);
                }else {
                    humano.setIsMutant(false);
                    return ihumanoRepository.save(humano);
                }

            }else{
                System.out.println("La matriz no es cuadrada");
                return ihumanoRepository.save(humano);
            }
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public StatsDto getStats(){
            float count_human_dna = 0;
            float count_mutant_dna = 0;
            float ratio;

            List<Humano> humanos = ihumanoRepository.findAll();

            for (Humano h : humanos){
                if (h.getIsMutant()) {
                    count_mutant_dna++;
                }else {
                    count_human_dna++;
                }
            }

            ratio = count_mutant_dna / humanos.size();

        return (StatsDto.builder()
                .count_human_dna((int)count_human_dna)
                .count_mutant_dna((int)count_mutant_dna)
                .ratio(ratio)
                .build());
    }
}
