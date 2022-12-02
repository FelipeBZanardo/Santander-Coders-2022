package comparator;

import model.Aula;

import java.util.Comparator;
import java.util.Map;

public class ComparadorAulaDuracaoMap implements Comparator<Map.Entry<String, Aula>> {
    @Override
    public int compare(Map.Entry<String, Aula> aluno1, Map.Entry<String, Aula> aluno2) {
        return Integer.compare(aluno1.getValue().getDuracao(), aluno2.getValue().getDuracao());
    }
}
