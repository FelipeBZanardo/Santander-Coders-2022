package comparator;

import model.Aula;

import java.util.Comparator;
import java.util.Map;

public class ComparadorAulaTitulo implements Comparator<Map.Entry<String, Aula>> {


    @Override
    public int compare(Map.Entry<String, Aula> aluno1, Map.Entry<String, Aula> aluno2) {
        return aluno1.getValue().getTitulo().compareTo(aluno2.getValue().getTitulo());
    }
}
