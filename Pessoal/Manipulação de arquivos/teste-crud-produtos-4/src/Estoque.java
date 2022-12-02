import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Estoque {

    public static Set<Produto> obterListaProdutos (List<String> dadosLidos){
        Set<Produto> listaProdutos = new LinkedHashSet<>();
        if (dadosLidos.size() != 0){
            for (String linha : dadosLidos){
                String[] produtos = linha.split(";");
                String nome = produtos[0];
                int quantidade = 0;
                double preco = 0d;
                try {
                    quantidade = Integer.parseInt(produtos[1]);
                    preco = Double.parseDouble(produtos[2]);
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException | NumberFormatException exception){
                    System.out.println("\u001B[31mArquivo de Estoque danificado\u001B[0m");
                    System.exit(0);
                }
                listaProdutos.add(new Produto(nome, quantidade, preco));
            }
        }
        return listaProdutos;
    }

    public static void imprimirEstoque(Set<Produto> listaProdutos){

        if (listaProdutos.size() == 0){
            System.out.println("\u001B[31mEstoque vazio!\u001B[0m");
        } else{
            System.out.println("\n****\tESTOQUE DE PRODUTOS\t****");
            System.out.println("====================================================");
            System.out.printf("%-20s %-20s %-20s\n",
                    "Produto", "Quantidade", "Preço(R$)");

            for(Produto produto : listaProdutos){
                System.out.println(produto.toString());
            }
        }
    }

    public static boolean verificarProduto(Set<Produto> listaProdutos, String nomeProduto){
        for (Produto produto : listaProdutos){
            if (produto.getNome().equals(nomeProduto)){
                return true;
            }
        }
        return false;

    }

    public static Produto criarProduto(Set<Produto> listaProdutos){
        while (true){
            String nomeProduto = EntradaDados.obterNomeProduto();
            if (verificarProduto(listaProdutos, nomeProduto)){
                System.out.println("Esse produto já existe");
                continue;
            }
            int quantidade = EntradaDados.obterQuantidade();
            double preco = EntradaDados.obterPreco();
            System.out.println("Produto criado com sucesso!");
            return new Produto(nomeProduto, quantidade, preco);
        }
    }

    public static Set<Produto> removerProduto(Set<Produto> listaProdutos){
        while (true){
            String nomeProduto = EntradaDados.obterNomeProduto();
            if (!verificarProduto(listaProdutos, nomeProduto)){
                System.out.println("Esse produto não existe");
                continue;
            }
            listaProdutos.remove(obterProduto(listaProdutos, nomeProduto));
            System.out.println("Produto removido com sucesso!");
            return listaProdutos;
        }
    }

    public static Set<Produto> atualizarProduto(Set<Produto> listaProdutos){
        String nome = "";
        int quantidade = 0;
        double preco = 0d;

        while (true){
            String nomeProduto = EntradaDados.obterNomeProduto();
            if (!verificarProduto(listaProdutos, nomeProduto)){
                System.out.println("Esse produto não existe");
                continue;
            }
            Produto produto = obterProduto(listaProdutos, nomeProduto);
            System.out.println("""
                    1 - Atualizar nome
                    2 - Atualizar quantidade
                    3 - Atualizar preço
                    """);
            switch (EntradaDados.obterOpcao(3)) {
                case 1 -> produto.setNome(EntradaDados.obterNomeProduto());
                case 2 -> produto.setQuantidade(EntradaDados.obterQuantidade());
                case 3 -> produto.setPreco(EntradaDados.obterPreco());
            }
            listaProdutos.add(produto);
            System.out.println("Produto atualizado com sucesso!");
            return listaProdutos;
        }
    }

    public static Produto obterProduto(Set<Produto> listaProdutos, String nome){
        for (Produto produto : listaProdutos){
            if(produto.getNome().equalsIgnoreCase(nome)){
                return produto;
            }
        }
        return null;        //nunca retornará null. Tratamento de erro já implementado
    }
}
