package tests;

import model.Aula;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestandoList {
    public static void main(String[] args) {
        //List permite elementos duplicados e mantém a ordem de inserção
        //A vantengem do List em relação ao Set é a
        // capacidade de busca dos elementos pelos índices
        //List<Aula> aulas = new ArrayList<>();

        List<Aula> aulas = new ArrayList<>();

        Aula aulaAngular = new Aula("Angular",50);

        aulas.add(new Aula("Java", 40));
        aulas.add(new Aula("JavaScript", 30));
        aulas.add(new Aula("Spring", 20));
        aulas.add(aulaAngular);
        aulas.add(aulaAngular);

        aulas.set(0,new Aula("Java 8", 40));

        System.out.println(aulas);

        //for (Aula aula : aulas)
        //    System.out.println(aula);

        //for(int i = 0; i < aulas.size(); i++)
        //    System.out.println(aulas.get(i));
    }
}
