import java.io.File;
import java.io.IOException;

public class Menu {
    public static void iniciarMenuPrincipal() throws IOException, InterruptedException {
        System.out.printf("%-7sMenu Principal%7s\n","*","*");
        System.out.println("""
                
                1 - Selecionar arquivo de Estoque
                2 - Criar arquivo de Estoque
                3 - Encerrar o programa
                """);

        switch (EntradaDados.escolherOpcao(3)) {
            case 1 -> {
                iniciarMenuCrud(EntradaDados.receberArquivo());
            }
            case 2 -> iniciarMenuCrud(EntradaDados.criarArquivo());
            case 3 -> {
                System.out.println("Fim do programa");
                System.exit(0);
            }
            default -> System.out.println("\u001B[31mErro desconhecido\u001B[0m");
        }
    }

    public static void iniciarMenuCrud (Arquivo arquivo) throws IOException {

        Estoque estoque = new Estoque(arquivo);

        limparTela();
        System.out.printf("%-7sMenu CRUD Produtos%7s\n","*","*");
        System.out.println("""
                
                1 - Criar novo produto - CREATE
                2 - Ler o estoque de produtos - READ
                3 - Atualizar dados - UPDATE
                4 - Remover um produto - DELETE
                5 - Encerrar o programa
                """);

        estoque.obterListaProdutos(arquivo.lerArquivo());
        switch (EntradaDados.escolherOpcao(5)) {
            case 1 -> {
                limparTela();
                estoque.imprimirEstoque();
                estoque.adicionarProduto();
                if (EntradaDados.voltarMenuAnterior())
                    iniciarMenuCrud(arquivo);
            }
            case 2 -> {
                limparTela();
                estoque.imprimirEstoque();
                if (EntradaDados.voltarMenuAnterior()){
                    limparTela();
                    iniciarMenuCrud(arquivo);
                }

            }
            case 3 -> {
                limparTela();
                iniciarMenuAtualizacao(estoque);
            }
            case 4 -> {
                limparTela();
                estoque.imprimirEstoque();
                estoque.removerProduto();
                if (EntradaDados.voltarMenuAnterior())
                    iniciarMenuCrud(arquivo);
            }
            case 5 -> {
                System.out.println("Fim do programa");
                System.exit(0);
            }
            default -> System.out.println("\u001B[31mErro desconhecido\u001B[0m");
        }
    }

    public static void iniciarMenuAtualizacao(Estoque estoque) throws IOException {
        System.out.println("""
                
                1 - Alterar nome do produto
                2 - Alterar quantidade do produto
                3 - Alterar preço do produto
                4 - Voltar Menu anterior
                """);


        switch (EntradaDados.escolherOpcao(4)) {
            case 1 -> {
                estoque.imprimirEstoque();
                estoque.atualizarNome();
                if (EntradaDados.voltarMenuAnterior())
                    iniciarMenuAtualizacao(estoque);
            }
            case 2 -> {
                estoque.imprimirEstoque();
                estoque.atualizarQuantidade();
                if (EntradaDados.voltarMenuAnterior())
                    iniciarMenuAtualizacao(estoque);
            }
            case 3 -> {
                estoque.imprimirEstoque();
                estoque.atualizarPreco();
                if (EntradaDados.voltarMenuAnterior())
                    iniciarMenuAtualizacao(estoque);
            }
            case 4 -> iniciarMenuCrud(estoque.getArquivo());
            default -> System.out.println("\u001B[31mErro desconhecido\u001B[0m");            //tratamento de erro já implementado
        }
    }

    public static void limparTela(){
        for (int i = 0; i < 200; i++) {
            System.out.println("\r\n");
        }
    }

}
