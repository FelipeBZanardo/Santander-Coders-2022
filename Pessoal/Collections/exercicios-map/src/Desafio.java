/*Faça um programa que simule um lançamento de dados
* Lance o dado 100 vezes e armazene
* Depois mostre quantas vezes cada valor foi inserido*/

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Desafio {
    public static void main(String[] args) {
        Map<Integer, Integer> dado = new LinkedHashMap<>();
        dado.put(1, 0);         //chave lado do dado
        dado.put(2, 0);         //value quantidade de vezes
        dado.put(3, 0);
        dado.put(4, 0);
        dado.put(5, 0);
        dado.put(6, 0);

        Random random = new Random();

        for(int i = 0 ; i < 100; i++){
            Integer ladoObtido = random.nextInt(6) + 1;
            dado.replace(ladoObtido, dado.get(ladoObtido) + 1);
        }

        System.out.println(dado);
    }
}
