import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDados {
    static Scanner scanner = new Scanner(System.in);

    public static boolean continuarMenu(){
        while (true){
            System.out.print("Voltar Menu? [S/N]");
            String resposta = scanner.nextLine().trim().toUpperCase();
            if(resposta.equals("S")){
                return true;
            } else if (resposta.equals("N")) {
                encerrarScanner();
                return false;
            } else {
                System.out.println("Digite apenas S para Sim ou N para Não");
            }
        }
    }

    public static int obterOpcao(int quantidade){
        int opcao = 0;
        while(true){
            try{
                System.out.print("Digite o número da opção: ");
                opcao = scanner.nextInt();
                if (opcao < 1 || opcao > quantidade){
                    System.out.println("\u001B[31mDigite de 1 a " + quantidade + "\u001B[0m");
                } else{
                    return opcao;
                }
            } catch (InputMismatchException exception){
                System.out.println("\u001B[31mDigite apenas números!\u001B[0m");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public static Arquivo obterArquivo(){
        while (true){
            System.out.print("Digite o nome do arquivo: ");
            String nomeArquivo = scanner.nextLine();
            if(!nomeArquivo.contains(".txt")){
                nomeArquivo += ".txt";
            }
            if (Files.exists(Path.of(nomeArquivo))){
                System.out.println("Arquivo selecionado com sucesso");
                return new Arquivo(nomeArquivo);
            } else if(criarArquivo()){
                System.out.println("Arquivo criado com sucesso");
                Arquivo.criarArquivo(nomeArquivo);
                return new Arquivo(nomeArquivo);
            }
        }
    }

    public static boolean criarArquivo(){
        while (true){
            System.out.print("Esse arquivo não existe. Deseja criá-lo? [S/N]");
            String resposta = scanner.nextLine().toUpperCase().trim();
            if (resposta.equals("S")){
                return true;
            } else if (resposta.equals("N")){
                return false;
            } else {
                System.out.println("Digite apenas S para Sim ou N para Não");
            }
        }
    }

    public static String obterNomeProduto(){
        System.out.print("Digite o nome do produto: ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public static int obterQuantidade(){
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

    public static double obterPreco(){
        double preco = 0d;
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

    public static void encerrarScanner(){
        scanner.close();
    }

}
