import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Arquivo {

    private String nomeArquivo;

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public List<String> lerArquivo(){
        while (true){
            try {
                return Files.readAllLines(Path.of(getNomeArquivo()));
            } catch (IOException exception){
                System.out.println("Nome de arquivo inválido!");
            }
        }
    }

    public boolean verificarArquivo(String nomeArquivo){
        return Files.exists(Path.of(nomeArquivo));
    }

    public boolean criarArquivo(String nome) {
        try {
            Files.createFile(Path.of(nome));
        } catch (IOException exception) {
            System.out.println("Arquivo inválido!");
        }
        return verificarArquivo(nome);
    }
}
