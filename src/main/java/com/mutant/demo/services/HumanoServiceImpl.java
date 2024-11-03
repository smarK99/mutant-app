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

    public boolean checkSquareMatrix(List<String> adn, Humano humano){
        boolean isSquare = true;
        //Chequea si la matriz es cuadrada
        for(int i = 0; i < adn.size(); i++){
            if (adn.get(i).length() == adn.size()) {
                System.out.println("Fila " + (i+1) + " chequeada exitosamente");
            }else {
                System.out.println("La matriz no es cuadrada!");
                humano.setIsMutant(false);
                isSquare = false;
                return isSquare;
            }
        }
        return isSquare;
    }

    public char[][] fillMatrix(List<String> adn, int n){

        char[][] matrizDna = new char[n][n];

        //Llena la matriz con el array de Strings
        for (int f = 0; f < n; f++) {
            for (int c = 0; c < n; c++) {
                matrizDna[f][c] = adn.get(f).charAt(c);
            }
        }
        return matrizDna;
    }

    public boolean checkRows(char[][] matrizDna){
        boolean resultado = false;

        for (int i = 0; i < matrizDna.length; i++) {
            int contador = 1;
            //La cuenta empieza desde n+1, es decir desde el elemento 0 1
            for (int j = 1; j < matrizDna.length; j++) {
                //Compara el elemento n con su anterior n-1
                if (matrizDna[i][j] == matrizDna[i][j - 1]) {
                    contador++;
                    if (contador >= 4) {
                        resultado = true;
                        break;
                    }
                } else {
                    contador = 1;
                }
            }
        }
        return resultado;
    }

    public boolean checkColumns(char[][] matrizDna){
        boolean resultado = false;

        for (int i = 0; i < matrizDna.length; i++) {
            int contador = 1;
            //La cuenta empieza desde n+1, es decir desde el elemento 0 1
            for (int j = 1; j < matrizDna.length; j++) {
                //Compara el elemento n con su anterior n-1
                if (matrizDna[j][i] == matrizDna[j-1][i]) {
                    contador++;
                    if (contador >= 4) {
                        resultado = true;
                        break;
                    }
                } else {
                    contador = 1;
                }
            }
        }
        return resultado;
    }

    public boolean checkDiagonal(char[][] matrizDna) {
        boolean resultado = false;
        int contador = 1;

        if(matrizDna.length >= 4){
            for (int i = 1; i < matrizDna.length; i++) {
                if(matrizDna[i][i] == matrizDna[i - 1][i - 1]){
                    contador++;
                    if (contador >= 4){
                        System.out.println("Mutante diagonal");
                        resultado = true;
                        return resultado;
                    }
                }else{
                    contador = 1;
                }
            }
        }
        return resultado;
    }

    @Override
    public Humano saveAndCheck(Humano humano) throws Exception {
        try{
            List<String> dna = humano.getDna();
            int n = dna.size();

            if (checkSquareMatrix(dna, humano)) {
                char[][] matrizDna = fillMatrix(dna,n);
                if (checkRows(matrizDna) || checkColumns(matrizDna) || checkDiagonal(matrizDna)) {
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

//    @Override
//    public boolean existsDna(Humano humano) {
//
//        List<Humano> humanos = ihumanoRepository.findAll();
//
//        for (Humano h : humanos){
//            boolean contains = humano.getDna().contains(h);
//            if (contains == true) {
//                System.out.println("El humano ya existe!");
//                return true;
//            }
//        }
//        return false;
//    }

}
