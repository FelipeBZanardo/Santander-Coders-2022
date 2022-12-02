import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDados {

    static Scanner scanner = new Scanner(System.in);

    static Arquivo arquivo = new Arquivo();
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
            System.out.print("Digite o nome do arquivo de estoque: ");
            String nomeArquivo =  scanner.nextLine();
            if (!nomeArquivo.contains(".txt")){
                nomeArquivo += ".txt";
            }
            if (arquivo.verificarArquivo(nomeArquivo)){
                System.out.println("Arquivo selecionado com sucesso!");
                arquivo.setNomeArquivo(nomeArquivo);
                break;
            } else if (criarArquivo()){
                if (arquivo.criarArquivo(nomeArquivo)){
                    System.out.println("Arquivo criado com sucesso");
                    arquivo.setNomeArquivo(nomeArquivo);
                }
                break;
            }
        }
        return arquivo;
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
}
