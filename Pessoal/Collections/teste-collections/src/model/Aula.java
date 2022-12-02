package model;

public class Aula implements Comparable<Aula>{

    private String titulo;
    private int duracao;

    public Aula (String titulo, int duracao){
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao(){
        return duracao;
    }

    @Override
    public String toString(){
        return "Aula[" +
                "titulo= " + titulo + '\'' +
                ", duracao= " + duracao + " horas" +
                        "]";
    }

    @Override
    public int compareTo(Aula outraAula) {
        return titulo.compareTo(outraAula.getTitulo());
    }
}
