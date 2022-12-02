package comparator;

import model.Aula;

import java.util.Comparator;

public class ComparadorAulaDuracao implements Comparator<Aula> {

    @Override
    public int compare(Aula aula1, Aula aula2) {
        return Integer.compare(aula1.getDuracao(), aula2.getDuracao());
    }
}
