import exceptions.OpcaoException;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void iniciarMenu() throws IOException {

        System.out.println("\t\t*****CRUD de Produtos*****\n");
        System.out.println("Antes de começar, preciso do nome do arquivo de estoque");

        File arquivo = obterArquivo();

        char resposta = 'S';
        while(resposta == 'S'){
            mostrarOpcoes();
            int opcao = obterOpcao();
            realizarTarefa(opcao, arquivo);

            boolean erro = true;
            while (erro) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Voltar ao menu? [S/N] ");
                resposta = scanner.next().toUpperCase().charAt(0);

                if (resposta == 'N') {
                    System.out.println("Fim do programa");
                    erro = false;
                } else if (resposta == 'S') {
                    erro = false;
                } else{
                    System.out.println("Digite S para Sim ou N para Não");
                }
            }
        }


    }

    public void mostrarOpcoes (){
        System.out.println("1 - Ver Estoque");
        System.out.println("2 - Criar Produto");
        System.out.println("3 - Atualizar Dados do Estoque");
        System.out.println("4 - Remover Produto do Estoque");
    }

    public File obterArquivo() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String pathArquivo = "";

        char resposta = 'N';

        boolean erro = true;
        while(erro){
            System.out.print("Há um arquivo de Estoque disponível na sua máquina? [S/N] ");
            resposta = scanner.next().toUpperCase().charAt(0);
            if (resposta == 'S') {
                pathArquivo = receberArquivo();
                erro = false;
            }
            else if (resposta == 'N') {
                pathArquivo = criarArquivo();
                erro = false;
            } else {
                System.out.println("Digite S para Sim ou N para Não");
            }
        }

        return new File(pathArquivo);
    }

    public String receberArquivo() {
        Scanner scanner = new Scanner(System.in);
        Arquivo arquivo = new Arquivo();

        String path = "";

        System.out.println("Agora preciso saber o caminho para o arquivo de estoque");

        boolean erro = true;

        while(erro){
            System.out.print("Digite o caminho: ");
            path = scanner.nextLine();

            if(arquivo.verificarArquivo(path)) {
                System.out.println("Arquivo localizado!");
                erro = false;
            }
            else
                System.out.println("Caminho inválido.");
        }

        return path;

    }

    public String criarArquivo() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos criar o arquivo de estoque");

        boolean erro = true;
        char resposta = 'N';
        String path = "";

        while (erro) {
            System.out.println("Será criado um arquivo no caminho Estoque/Estoque.txt");
            System.out.print("Deseja alterar esse caminho? [S/N]: ");
            resposta = scanner.next().toUpperCase().charAt(0);

            if (resposta == 'S'){
                System.out.print("Digite seguindo o exemplo: Diretorio/Arquivo.txt");
                path = scanner.next();

                Arquivo arquivo = new Arquivo();
                System.out.println("Arquivo criado com sucesso: " + arquivo.criarArquivo(path));
                erro = false;
            } else if (resposta == 'N') {
                path = "Estoque/Estoque.txt";
                Arquivo arquivo = new Arquivo();
                System.out.println("Arquivo criado com sucesso: " + arquivo.criarArquivo(path));
                erro = false;
            } else {
                System.out.println("Digite apenas S para Sim e N para Não");
            }
        }

        return path;
    }

    public int obterOpcao (){
        boolean erro = true;
        int opcao = 0;

        while(erro){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nEscolha uma das opções: ");
                opcao = scanner.nextInt();

                if(opcao < 1 || opcao > 4){
                    throw new OpcaoException("Número inválido!");
                }

                erro = false;
            } catch (InputMismatchException exception){
                System.out.println("Digite apenas números!");
            } catch (OpcaoException exception){
                System.err.println(exception.getMessage());
                System.out.println("Digite apenas números de 1 a 4");
            }
        }

        return opcao;
    }

    public void realizarTarefa (int opcao, File arquivo) throws IOException {

        Crud crud = new Crud(arquivo);

        switch (opcao){
            case 1:
                crud.lerEstoque();
                break;
            case 2:
                crud.criarProduto();
                break;
            case 3:
                crud.atualizarEstoque();
                break;
            case 4:
                crud.deletarProduto();
                break;
            default:
                System.out.println("Erro desconhecido");
        }
    }
}
