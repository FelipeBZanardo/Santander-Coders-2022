import java.util.Comparator;

public class ComparadorIde implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita linguagem1, LinguagemFavorita linguagem2) {
        return linguagem1.getIde().compareTo(linguagem2.getIde());
    }
}
