import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        /*String diretorio = "Estoque";
        String file = "Estoque.txt";
        Arquivo arquivo = new Arquivo(diretorio, file);
        List<String> arquivoLidos = arquivo.lerArquivo();
        Produto produto = new Produto();

        Set<Produto> produtos = produto.obtemProdutos(arquivoLidos);
        System.out.println(produtos);*/

        Menu menu = new Menu();
        menu.iniciarMenu();

    }
}
