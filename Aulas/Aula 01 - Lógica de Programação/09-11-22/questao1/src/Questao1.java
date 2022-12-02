/*Faça um programa que receba uma frase com
"Janeiro: 1543, Fevereiro: 1222, Março: 1234".
Imprima sequencialmente em linhas separadas por cada mês
e na última linha a frase:
"Total: " e o valor da soma de todos os meses.
Exemplo:
Janeiro: 1543
Fevereiro: 1222
Março: 1234
Total: 3999*/

import java.util.Arrays;

public class Questao1 {
    public static void main(String[] args) {
        String frase = "Janeiro:     1543,    Fevereiro:    1222, Março: 1234";
        frase = frase.replaceAll("\\s+", " ");

        String[] meses = frase.split(",");          //separa a string em cada mês mais o valor


        int soma = 0;
        for (String mes : meses){
            soma += Integer.parseInt(mes.substring(mes.indexOf(":") + 2));
            System.out.println(mes.trim());             //elimina o espaço que há antes do mês e imprime na tela
        }
        System.out.println("Total: " + soma);

    }
}
