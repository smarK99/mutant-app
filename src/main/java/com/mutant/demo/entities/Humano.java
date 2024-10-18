package com.mutant.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Table(name = "humano")
public class Humano extends Base{

    private List<String> dna;

    private Boolean isMutant;

    public boolean checkSquareMatrix(List<String> adn){
        boolean isSquare = true;
        //Chequea si la matriz es cuadrada
        for(int i = 0; i < adn.size(); i++){
            if (adn.get(i).length() == adn.size()) {
                System.out.println("Fila " + (i+1) + " chequeada exitosamente");
            }else {
                System.out.println("La matriz no es cuadrada!");
                this.setIsMutant(false);
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


}
