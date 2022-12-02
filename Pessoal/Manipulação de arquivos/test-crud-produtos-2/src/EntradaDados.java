import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class EntradaDados {
    static Scanner scanner = new Scanner(System.in);
    public static int escolherOpcao (int quantidade){
        boolean erro = true;
        int opcao = 0;
        while(erro){
            try{
                System.out.print("Digite o número da opção: ");
                opcao = scanner.nextInt();
                if (opcao < 1 || opcao > quantidade){
                    throw new OpcaoInvalidaException("\u001B[31mDigite de 1 a " + quantidade + "\u001B[0m");
                }
                erro = false;
            } catch (InputMismatchException exception){
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            } catch (OpcaoInvalidaException exception){
                System.out.println(exception.getMessage());
            } finally {
                scanner.nextLine();
            }
        }

        return opcao;
    }

    public static Arquivo receberArquivo() throws IOException, InterruptedException {

        String path = "";

        while (true){
            System.out.print("Digite o caminho com o nome do Arquivo ou 0 para sair: ");
            path = scanner.nextLine();
            if (path.equals("0")){
                Menu.iniciarMenuPrincipal();
            }
            Arquivo arquivo = new Arquivo(path);
            if(arquivo.verificarArquivo()){
                System.out.println("\u001B[32mArquivo encontrado com sucesso!\u001B[0m");
                TimeUnit.SECONDS.sleep(3);
                return arquivo;
            } else{
                System.out.println("\u001B[31mArquivo não encontrado\u001B[0m");
            }
        }
    }

    public static Arquivo criarArquivo() throws IOException, InterruptedException {
        System.out.print("Digite o nome do arquivo a ser criado: ");
        String path = scanner.nextLine();

        if(!path.contains(".txt")){
            path += ".txt";
        }

        Arquivo arquivo = new Arquivo(path);
        if (arquivo.criarArquivo()){
            System.out.println("\u001B[32mArquivo criado com sucesso\u001B[0m");
            TimeUnit.SECONDS.sleep(3);
        }

        return arquivo;
    }

    public static String receberNomeProdutoAtualizacao(Estoque estoque){
        String nome = "";
        while(true){
            System.out.print("Digite o nome do produto a ser atualizado: ");
            nome = scanner.nextLine().trim().toUpperCase();
            if (estoque.verificarProduto(nome)){
                return nome;
            } else {
                System.out.println("\u001B[31mProduto não encontrado!\u001B[0m");
            }
        }
    }

    public static String receberNomeProduto(Estoque estoque){
        String nome = "";
        while(true){
            System.out.print("Digite o nome do produto: ");
            nome = scanner.nextLine().trim().toUpperCase();
            if (!estoque.verificarProduto(nome)){
                return nome;
            } else {
                System.out.println("\u001B[31mProduto já existente no estoque\u001B[0m");
            }
        }
    }

    public static int receberQuantidadeProduto(Estoque estoque){
        int quantidade = 0;
        while (true){
            try{
                System.out.print("Digite a quantidade do produto: ");
                quantidade = scanner.nextInt();
                return quantidade;
            } catch (InputMismatchException exception){
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public static double receberPrecoProduto(Estoque estoque){
        double preco = 0;
        while (true){
            try{
                System.out.print("Digite o preço do produto: ");
                preco = scanner.nextDouble();
                return preco;
            } catch (InputMismatchException exception){
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public static boolean voltarMenuAnterior(){
        while (true){
            System.out.print("Deseja voltar ao menu anterior? [S/N] ");
            String escolha = scanner.nextLine().trim().toUpperCase();
            if (escolha.equals("S")){
                return true;
            } else if (escolha.equals("N")) {
                System.out.println("Fim do programa");
                System.exit(0);
            } else {
                System.out.println("\u001B[31mDigite apenas S para sim ou N para Não\u001B[0m");
            }
        }
    }
}
