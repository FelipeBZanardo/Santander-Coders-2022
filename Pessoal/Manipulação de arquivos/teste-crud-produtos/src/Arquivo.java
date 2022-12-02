import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Arquivo {
    private String path;

    public Arquivo() {
    }

    public boolean verificarArquivo (String path){
        File file = new File(path);

        return (file.exists());
    }

    public boolean criarArquivo (String path) throws IOException {
        File file = new File(path);

        return (file.createNewFile());

    }

    public List<String> lerArquivo(File file){

        List<String> dadosLidos = new LinkedList<>();

        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()){
                String linha = bufferedReader.readLine();
                dadosLidos.add(linha);
            }

            //System.out.println(dadosLidos);

            bufferedReader.close();
            fileReader.close();

        }catch (FileNotFoundException exception){
            System.out.println("Arquivo não encontrado!");
        } catch (IOException exception){
            System.out.println("Dados não encontrados!");
        }

        return dadosLidos;
    }

    public void escreverArquivo (File file, List<Produto> listProduto) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Produto produto : listProduto){
            String linha = produto.getId() + ";" + produto.getNome() + ";" + produto.getPreco();
            bufferedWriter.write(linha);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        fileWriter.close();

        System.out.println("Estoque atualizado com sucesso!");

    }
}
