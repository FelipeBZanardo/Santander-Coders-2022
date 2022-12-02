import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Arquivo {
    private String path;

    public Arquivo() {
    }

    public Arquivo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static void criarArquivo(String nomeArquivo){
        try {
            Files.createFile(Path.of(nomeArquivo));
        }catch (IOException exception){
            System.out.println("Arquivo inválido");
        }
    }

    public List<String> lerArquivo(){
        while (true){
            try {
                return Files.readAllLines(Path.of(this.path));
            } catch (IOException exception){
                System.out.println("Nome de arquivo inválido!");
            }
        }
    }

    public void escreverArquivo(Set<Produto> listaProdutos){

        List<String> linhasAEscrever = new ArrayList<>();

        for (Produto produto : listaProdutos){
            String linha = produto.getNome() + ";" + produto.getQuantidade() + ';' + produto.getPreco();
            linhasAEscrever.add(linha);
        }

        try{
            Files.write(Path.of(this.path), linhasAEscrever);
        } catch (IOException exception){
            System.out.println("Arquivo inválido");
        }
    }
}
