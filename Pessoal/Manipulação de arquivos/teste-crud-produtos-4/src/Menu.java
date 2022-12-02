import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Menu {

    public void iniciarMenu(Arquivo arquivo){
        System.out.println("""
                *********Menu CRUD PRODUTOS*********
                
                1 - Criar novo Produto - CREATE
                2 - Ler estoque de Produtos - READ
                3 - Atualizar Produto - UPDATE
                4 - Remover Produto - DELETE
                5 - Encerrar Programa
                """);

        List<String> dadosLidos = arquivo.lerArquivo();
        Set<Produto> listaProdutos = Estoque.obterListaProdutos(dadosLidos);


        switch (EntradaDados.obterOpcao(5)){
            case 1:
                Produto produtoNovo = Estoque.criarProduto(listaProdutos);
                listaProdutos.add(produtoNovo);
                arquivo.escreverArquivo(listaProdutos);
                if (EntradaDados.continuarMenu()){
                    iniciarMenu(arquivo);
                }
                break;
            case 2:
                Estoque.imprimirEstoque(listaProdutos);
                if (EntradaDados.continuarMenu()){
                    iniciarMenu(arquivo);
                }
                break;
            case 3:
                Estoque.imprimirEstoque(listaProdutos);
                if (listaProdutos.size() != 0){
                    listaProdutos = Estoque.atualizarProduto(listaProdutos);
                    arquivo.escreverArquivo(listaProdutos);
                }
                if (EntradaDados.continuarMenu()){
                    iniciarMenu(arquivo);
                }
                break;
            case 4:
                Estoque.imprimirEstoque((listaProdutos));
                if(listaProdutos.size() != 0){
                    listaProdutos = Estoque.removerProduto(listaProdutos);
                    arquivo.escreverArquivo(listaProdutos);
                }
                if (EntradaDados.continuarMenu()){
                    iniciarMenu(arquivo);
                }
                break;
            case 5:
                System.out.println("Fim do programa!");
                EntradaDados.encerrarScanner();
                System.exit(0);
                break;
        }
    }

}
