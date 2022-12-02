/*Faça um programa que pegue o nome completo que o
usuário digitar e imprima o nome com cada parte
separada por espaço, um símbolo de exclamação no início.
Exemplo:
Nome: João Mario da Silva

Resultado: !João !Maria !da !Silva*/

import java.util.Arrays;
import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome completo\nNome: ");
        String nomeEntrada = scanner.nextLine().trim();
        String nome = "!" + nomeEntrada.replaceAll("\\s+", " !");
        //String nome = "!" + nomeEntrada.replace(" ", " !");

        System.out.println("Resultado: " + nome);



        /*System.out.print("Digite seu nome completo\nNome: ");
        String nomeEntrada = " " + scanner.nextLine().trim();

        String[] nomes = nomeEntrada.split(" +");
        String resultado = String.join(" !", nomes).trim();
        System.out.println("Resultado: " + resultado);*/

        /*String nomeModificado = "";
        for (String nomeSobrenome : nomes){
            nomeModificado += " !" + nomeSobrenome;
        }*/

        /*String[] nomeModificado = new String[nomes.length * 2];
        for (int i = 0; i < nomeModificado.length; i++) {
            if (i % 2 == 0)
                nomeModificado[i] = " !";
            else
                nomeModificado[i] = nomes[i/2];
        }*/

        String[] nomeModificado = {" ", "Felipe", " ", "Bueno", " ", "Zanardo"};


        //System.out.println("Resultado" + String.join(" ".concat("!"),nomes));
    }
}
