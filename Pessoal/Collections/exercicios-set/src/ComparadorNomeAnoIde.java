import java.util.Comparator;

public class ComparadorNomeAnoIde implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita linguagem1, LinguagemFavorita linguagem2) {
        Integer nome =  linguagem1.getNome().compareTo(linguagem2.getNome());
        Integer ano = Integer.compare(linguagem1.getAnoCriacao(), linguagem2.getAnoCriacao());
        if (nome != 0) return nome;
        if (ano != 0) return ano;
        return linguagem1.getIde().compareTo(linguagem2.getIde());
    }
}
