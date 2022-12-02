package controller;

import model.Produto;
import view.ProdutoView;

import java.util.Map;

public class ProdutoController {

    private ProdutoView view;

    public void menu() {
        view = new ProdutoView();
        boolean continuar = true;
        while (continuar){
            String opcao = view.pegarOpcaoMenu();
            switch (opcao){
                case "1" -> criarProduto();
                case "2" -> listarProduto();
                case "3" -> editarProduto();
                case "4" -> excluirProduto();
                case "5" -> somarPrecos();
                case "0" -> {
                    view.fecharScanner();
                    continuar = false;
                }
                default -> System.out.println("Opção inválida");

            }
        }
    }

    public void criarProduto(){
        Map<String, Object> produto = view.pegarInformacoesProduto();
        Produto.listaProdutos.add(produto);
        System.out.println("Produto criado com sucesso");
    }
    
    public void editarProduto(){
        listarProduto();
        if (Produto.listaProdutos.size() != 0) {
            int id = view.pegarIdProduto();
            String nome = view.pegarNomeProduto();
            Integer quantidade = view.pegarQuantidadeProduto();
            Double preco = view.pegarPrecoProduto();
            Map<String, Object> produto = Produto.listaProdutos.get(id);
            produto.put("nome", nome);
            produto.put("quantidade", quantidade);
            produto.put("preco", preco);
            System.out.println("Estoque atualizado com sucesso");
        }
    }
    
    public void listarProduto(){
        if (Produto.listaProdutos.size() == 0){
            System.out.println("Estoque vazio");
        } else {
            view.listarProduto();
        }
    }
    
    public void excluirProduto(){
        listarProduto();
        if (Produto.listaProdutos.size() != 0){
            int id = view.pegarIdProduto();
            Produto.listaProdutos.remove(id);
            System.out.println("Produto removido com sucesso");
        }
    }
    
    public void somarPrecos(){
        listarProduto();
        if (Produto.listaProdutos.size() != 0){
            double soma = 0d;
            for(Map<String,Object> produto : Produto.listaProdutos){
                soma += (Double) produto.get("preco");
            }
            System.out.printf("Total: R$%.2f",soma);
        }
    }
}
