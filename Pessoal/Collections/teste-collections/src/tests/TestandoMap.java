package tests;

import comparator.ComparadorAulaDuracaoMap;
import comparator.ComparadorAulaTitulo;
import model.Aula;

import java.text.CollationElementIterator;
import java.util.*;

public class TestandoMap {

    public static void main(String[] args) {
        Map<String, Aula> alunos = new HashMap<>();           //sem ordenação
        //Map<String, Aula> alunos = new LinkedHashMap<>();       //ordem de inserção
        //Map<String, Aula> alunos = new TreeMap<>();               //ordem natural da chave

        Aula aula0 = new Aula("Java",20);
        Aula aula1 = new Aula("JavaScript",30);
        Aula aula2 = new Aula("Angular",10);
        Aula aula3 = new Aula("Spring",20);
        Aula aula4 = new Aula("Python",100);

        alunos.put("Felipe", aula0);
        alunos.put("Bruno", aula1);
        alunos.put("Cleusa", aula2);
        alunos.put("Pamela", aula3);
        alunos.put("Zanardo", aula4);
        alunos.put("Bueno", aula4);

        System.out.println(alunos);

        //alunos.remove("Felipe");
        //System.out.println(alunos);

        //alunos.replace("Felipe", aula4);
        //System.out.println(alunos);

        /*for (String nome : alunos.keySet()){
            System.out.println(nome);
        }*/

        /*for (Aula aula : alunos.values()){
            System.out.println(aula);
        }*/

        /*for(Map.Entry<String, Aula> aluno : alunos.entrySet()){
            System.out.println("Nome: " + aluno.getKey() + " Aula: " + aluno.getValue());
        }*/

        //Aluno matriculado na aula com maior duração e menor duração
        /*List<Integer> duracoes = new ArrayList<>();

        for(Aula aula : alunos.values()){
            duracoes.add(aula.getDuracao());
        }
        System.out.println(duracoes);
        Integer duracaoMaxima = Collections.max(duracoes);
        Integer duracaoMinima = Collections.min(duracoes);

        List<Aula> aulasMaiores = new ArrayList<>();
        List<Aula> aulasMenores = new ArrayList<>();
        for (Aula aula : alunos.values()){
            if(aula.getDuracao() == duracaoMaxima){
                aulasMaiores.add(aula);
            }
            if(aula.getDuracao() == duracaoMinima){
                aulasMenores.add(aula);
            }
        }

        System.out.println("Alunos nas aulas com maiores duração: ");
        for(Map.Entry<String, Aula> entryAlunos : alunos.entrySet()){
            for (Aula aula : aulasMaiores){
                if (aula.equals(entryAlunos.getValue())){
                    System.out.print(entryAlunos.getKey() + "/");
                    break;
                }
            }
        }
        System.out.println("\nAlunos nas aulas com menores duração: ");
        for(Map.Entry<String, Aula> entryAlunos : alunos.entrySet()){
            for (Aula aula : aulasMenores){
                if (aula.equals(entryAlunos.getValue())){
                    System.out.print(entryAlunos.getKey() + "/");
                    break;
                }
            }
        }*/

        /*for (Map.Entry<String, Aula> alunosEntry : alunos.entrySet()){
            System.out.println(alunosEntry.getKey() + " - " + alunosEntry.getValue().getDuracao());
        }*/

        Set<Map.Entry<String, Aula>> setAula = new TreeSet<>(new ComparadorAulaTitulo());
        setAula.addAll(alunos.entrySet());
        System.out.println(setAula);

        Set<Map.Entry<String, Aula>> setAula2 = new TreeSet<>(new ComparadorAulaDuracaoMap());
        setAula2.addAll(alunos.entrySet());
        System.out.println(setAula2);


    }
}
