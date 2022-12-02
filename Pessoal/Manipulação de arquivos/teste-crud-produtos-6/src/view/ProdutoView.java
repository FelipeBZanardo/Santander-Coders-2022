package view;

import model.Produto;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ProdutoView {
    Scanner scanner = new Scanner(System.in);

    public String pegarOpcaoMenu(){
        System.out.println("""
                
                1 - Criar novo Produto - CREATE
                2 - Ler estoque de Produtos - READ
                3 - Atualizar Produto - UPDATE
                4 - Remover Produto - DELETE
                5 - Somar Preços Produtos
                0 - Encerrar Programa
                """);
        System.out.print("Digite a opção desejada: ");
        return scanner.nextLine();
    }

    public Map<String, Object> pegarInformacoesProduto(){
        Map<String, Object> produto = new HashMap<>();

        String nome = pegarNomeProduto();
        Integer quantidade = pegarQuantidadeProduto();
        Double preco = pegarPrecoProduto();
        produto.put("nome", nome);
        produto.put("quantidade", quantidade);
        produto.put("preco", preco);

        return produto;
    }

    public String pegarNomeProduto(){
        System.out.print("Digite nome produto: ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public Integer pegarQuantidadeProduto(){
        while (true){
            try{
                System.out.print("Digite a quantidade: ");
                Integer quantidade = scanner.nextInt();
                if (quantidade <= 0){
                    System.out.println("\u001B[31mQuantidade inválida\u001B[0m");
                } else{
                    return quantidade;
                }
            } catch (InputMismatchException exception){
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public Double pegarPrecoProduto(){
        while (true){
            try{
                System.out.print("Digite o preço: R$");
                Double preco =  scanner.nextDouble();
                if (preco <= 0){
                    System.out.println("\u001B[31mPreço inválido\u001B[0m");
                } else {
                    return preco;
                }
            } catch (InputMismatchException exception){
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public int pegarIdProduto(){
        while(true){
            try{
                System.out.print("Digite o número do Identificador do produto: ");
                int id = scanner.nextInt();
                if (id < 0 || id >= Produto.listaProdutos.size()){
                    System.out.println("\u001B[31mEsse id não existe!\u001B[0m");
                } else {
                    return id;
                }
            } catch (InputMismatchException exception){
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            } finally {
                scanner.nextLine();
            }

        }


    }

    public void listarProduto(){
        System.out.println("\n****\tESTOQUE DE PRODUTOS\t****");
        System.out.println("=============================================================================");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n",
                "Identificador","Produto", "Quantidade", "Preço(R$)", "Total(R$)");

        for (int i = 0; i < Produto.listaProdutos.size() ; i++) {
            Map<String, Object> produto = Produto.listaProdutos.get(i);

            System.out.printf("%-15d %-15s %-15s %-15.2f %-15.2f\n",
                    i, produto.get("nome"), produto.get("quantidade"),
                    (Double) produto.get("preco"),
                    (Integer) produto.get("quantidade") * (Double) produto.get("preco"));
        }
    }

    public void fecharScanner(){
        scanner.close();
    }
}
