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
                return scanner.nextInt();
            } catch (InputMismatchException exception){
                System.out.println("Digite apenas números");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public Double pegarPrecoProduto(){
        while (true){
            try{
                System.out.print("Digite o preço: R$");
                return scanner.nextDouble();
            } catch (InputMismatchException exception){
                System.out.println("Digite apenas números");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public int pegarIdProduto(){
        while(true){
            try{
                System.out.print("Digite o número do Idendificador do produto: ");
                int id = scanner.nextInt();
                if (id < 0 || id >= Produto.listaProdutos.size()){
                    System.out.println("Esse id não existe!");
                } else {
                    return id;
                }
            } catch (InputMismatchException exception){
                System.out.println("Digite apenas números");
            } finally {
                scanner.nextLine();
            }

        }


    }

    public void listarProduto(){
        System.out.println("\n****\tESTOQUE DE PRODUTOS\t****");
        System.out.println("=============================================================================");
        System.out.printf("%-20s %-20s %-20s %-20s\n",
                "Identificador","Produto", "Quantidade", "Preço(R$)");

        for (int i = 0; i < Produto.listaProdutos.size() ; i++) {
            Map<String, Object> produto = Produto.listaProdutos.get(i);

            System.out.printf("%-20d %-20s %-20s %-20s\n",
                    i, produto.get("nome"), produto.get("quantidade"),
                    produto.get("preco"));
        }
    }

    public void fecharScanner(){
        scanner.close();
    }
}
