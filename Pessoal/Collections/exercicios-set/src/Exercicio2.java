/*Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
        Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
        a) Ordem de inserção;
        b) Ordem natural(nome);
        c) IDE;
        d) Ano de criação e nome;
        e) Nome, ano de criação e IDE;
        Ao final, exiba as linguagens no console, um abaixo da outra.*/

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Exercicio2 {
    public static void main(String[] args) {
        LinguagemFavorita linguagem1 = new LinguagemFavorita("Java", 1991,"IntelliJ");
        LinguagemFavorita linguagem2 = new LinguagemFavorita("Java", 1991,"VS Code");
        LinguagemFavorita linguagem3 = new LinguagemFavorita("Python", 1991,"PyCharm");

        //Set<LinguagemFavorita> linguagens = new LinkedHashSet<>(); //ordem de inserção

        //Set<LinguagemFavorita> linguagens = new TreeSet<>(); //ordem nome
        //Set<LinguagemFavorita> linguagens = new TreeSet<>(new ComparadorIde()); //ordem ide
        //Set<LinguagemFavorita> linguagens = new TreeSet<>(new ComparadorAnoENome()); //ordem ano e nome
        Set<LinguagemFavorita> linguagens = new TreeSet<>(new ComparadorNomeAnoIde()); //ordem nome, ano e ide

        linguagens.add(linguagem2);
        linguagens.add(linguagem1);
        linguagens.add(linguagem3);

        System.out.println(linguagens);


    }
}

