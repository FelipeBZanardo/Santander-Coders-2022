import java.io.*;
import java.util.Arrays;

public class TestandoArquivos {
    public static void main(String[] args) throws IOException {

        File diretorio = new File("Arquivos Criados");
        System.out.println("Diretório criado com sucesso: " + (diretorio.mkdir() ? "Sim" : "Não"));

        File[] files = diretorio.listFiles();
        System.out.println(Arrays.toString(files));

        //File arquivo = new File(diretorio, "Arquivo1.txt");
        File arquivo = files[0];
        if (!arquivo.exists()){
            System.out.println("Arquivo criado com sucesso ? " + arquivo.createNewFile());
        } else {
            System.out.println("Esse arquivo já existe!");
        }

        File arquivo2 = new File(diretorio, "Arquivo Renomeado.txt");
        System.out.println("Arquivo renomeado ? " + arquivo.renameTo(arquivo2));

        for (File file : diretorio.listFiles()){
            if(file.isFile())
                System.out.println(file.getName() + " é arquivo");
            if(file.isDirectory())
                System.out.println(file.getName() + " é diretório");
        }

    }
}
