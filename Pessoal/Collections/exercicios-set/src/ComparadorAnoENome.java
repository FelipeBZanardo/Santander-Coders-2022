import java.util.Comparator;

public class ComparadorAnoENome implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita linguagem1, LinguagemFavorita linguagem2) {
        Integer anoCriacao = Integer.compare(linguagem1.getAnoCriacao(), linguagem2.getAnoCriacao());
        if (anoCriacao != 0)
            return anoCriacao;
        return linguagem1.getNome().compareTo(linguagem2.getNome());
    }
}
