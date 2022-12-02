import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime.
As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita",
entre 3 e 4 como "Cúmplice" e 5 como "Assassina".
Caso contrário, ele será classificado como "Inocente".*/
public class Exercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> perguntas = new LinkedList<>();
        perguntas.add("Telefonou para a vítima? ");
        perguntas.add("Esteve no local do crime? ");
        perguntas.add("Mora perto da vítima? ");
        perguntas.add("Devia para a vítima? ");
        perguntas.add("Já trabalhou com a vítima? ");

        List<Boolean> respostas = new LinkedList<>();

        int somaTrue = 0;


        for (String pergunta : perguntas){
            System.out.println(pergunta);
            Boolean resposta = scanner.nextBoolean();
            if (resposta) somaTrue++;
            respostas.add(resposta);
        }

        if (somaTrue < 2)
            System.out.println("Inocente!");
        else if (somaTrue == 2)
            System.out.println("Suspeita");
        else if (somaTrue < 5)
            System.out.println("Cúmplice");
        else
            System.out.println("Assassina");

    }
}
