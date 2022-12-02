import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Antes de começar, selecione o arquivo.txt");
        Arquivo arquivo = EntradaDados.obterArquivo();
        Menu menu = new Menu();
        menu.iniciarMenu(arquivo);
    }


}
