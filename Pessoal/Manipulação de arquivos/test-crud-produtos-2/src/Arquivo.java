import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class Arquivo {

    private String path;

    private File file;

    public Arquivo(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public File getFile() {
        return file;
    }

    public boolean verificarArquivo(){
        return (file.exists());
    }

    public boolean criarArquivo() throws IOException {
        return (file.createNewFile());
    }

    public Set<String> lerArquivo() throws IOException {

        Set<String> dadosLidos = new LinkedHashSet<>();

        FileReader fileReader = new FileReader(this.file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while(bufferedReader.ready()){
            String linha = bufferedReader.readLine();
            dadosLidos.add(linha);
        }

        bufferedReader.close();
        fileReader.close();

        return dadosLidos;
    }

    public void escreverArquivo(Set<Produto> produtos) throws IOException {
        FileWriter fileWriter = new FileWriter(this.file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Produto produto : produtos){
            String linha = produto.getNome() + ";" + produto.getQuantidade()
                    + ";" + produto.getPreco();
            bufferedWriter.write(linha);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        fileWriter.close();

        System.out.println("\u001B[32mEstoque atualizado com sucesso\u001B[0m");
    }
}
