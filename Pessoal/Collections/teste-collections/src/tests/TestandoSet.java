package tests;

import comparator.ComparadorAulaDuracao;
import model.Aula;

import java.util.*;

public class TestandoSet {
    public static void main(String[] args) {
        //Set não permite elementos duplicados
        //HashSet não mantém nenhum tipo de ordenação dos elementos
        //Set<Aula> aulas = new HashSet<>();

        //TreeSet ordena o Set de acordo com a ordem natural dos elementos
        //Se o tipo for uma classe criada, deve-se implementar o Comparable
        //String e Wrappers já tem implementado essa interface!
        Set<String> nomes = new TreeSet<>();
        nomes.add("Felipe");
        nomes.add("Bruno");
        nomes.add("Cleusa");

        //System.out.println(nomes);

        //Set<Aula> aulas = new TreeSet<>();

        //LinkedHasSet ordena os elemento pela ordem de inserção
        //Não é necessário o uso do Comparable
        Set<Aula> aulas = new LinkedHashSet<>();

        Aula aulaAngular = new Aula("Angular",50);

        aulas.add(new Aula("Java", 40));
        aulas.add(new Aula("JavaScript", 30));
        aulas.add(new Aula("Spring", 20));
        aulas.add(aulaAngular);
        aulas.add(aulaAngular);

        //System.out.println(aulas);

        aulas.remove(aulaAngular);

        for (Aula aula : aulas){
            System.out.println(aula);
        }

        Set<Aula> aulaSet = new TreeSet<>(new ComparadorAulaDuracao());
        aulaSet.addAll(aulas);

        System.out.println(aulaSet);








    }
}
