import exceptions.OpcaoException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Crud {
    //CRUD : CREATE, READ, UPDATE, DELETE

    private File file;

    public Crud(File file) {
        this.file = file;
    }

    public void criarProduto() throws IOException {
        Arquivo arquivo = new Arquivo();
        List<String> dadosEstoque = arquivo.lerArquivo(this.file);
        List<Produto> listProdutos = new LinkedList<>();

        for (String linha : dadosEstoque){
            String[] produtoLinha = linha.split(";");
            Integer idLinha = Integer.parseInt(produtoLinha[0]);
            String nomeLinha = produtoLinha[1];
            Double precoLinha = Double.parseDouble(produtoLinha[2]);
            listProdutos.add(new Produto(idLinha, nomeLinha, precoLinha));
        }

        String nome = "";
        boolean erroProduto = true;
        while (erroProduto){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome do produto: ");
            nome = scanner.nextLine();
            boolean produtoRepetido = false;
            for (Produto produto : listProdutos){
                if(nome.equalsIgnoreCase(produto.getNome())){
                    System.out.println("Esse produto já existe. Digite outro nome");
                    produtoRepetido = true;
                    break;
                }
            }
            if (!produtoRepetido)
                erroProduto = false;
        }

        Double preco = 0d;

        boolean erro = true;
        while (erro){
            try{
                Scanner scanner2 = new Scanner(System.in);
                System.out.print("Digite o preço do produto: R$");
                preco = scanner2.nextDouble();
                erro = false;
            } catch (InputMismatchException exception){
                System.out.println("Digite apenas números!");
            }
        }

        Integer id = 1;
        if (listProdutos.size() != 0){
            id = listProdutos.get(listProdutos.size() - 1).getId() + 1;
        }
        listProdutos.add(new Produto(id,nome, preco));
        arquivo.escreverArquivo(this.file, listProdutos);
    }

    public void lerEstoque() {
        Arquivo arquivo = new Arquivo();
        List<String> dadosEstoque = arquivo.lerArquivo(this.file);

        if (dadosEstoque.size() == 0){
            System.out.println("Não há produtos cadastrados!");
        } else {
            System.out.printf("%-30s %-30s %-30s\n","Id","Nome","Preço(R$)");
            for (String linha : dadosEstoque) {
                String[] produtos = linha.split(";");
                System.out.printf("%-30s %-30s %-30s\n",produtos[0],produtos[1],produtos[2]);
            }
        }
    }

    public void atualizarEstoque() throws IOException {
        Arquivo arquivo = new Arquivo();
        List<String> dadosEstoque = arquivo.lerArquivo(this.file);
        List<Produto> listProdutos = new LinkedList<>();

        for (String linha : dadosEstoque){
            String[] produtoLinha = linha.split(";");
            Integer idLinha = Integer.parseInt(produtoLinha[0]);
            String nomeLinha = produtoLinha[1];
            Double precoLinha = Double.parseDouble(produtoLinha[2]);
            listProdutos.add(new Produto(idLinha, nomeLinha, precoLinha));
        }

        lerEstoque();

        int id = 0;
        boolean erro = true;
        while(erro){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o número do id do produto para alteração: ");
                id = scanner.nextInt();
                if (id < 1 || id > listProdutos.size() + 1){
                    throw new OpcaoException("Id inválido");
                }
                erro = false;
            } catch (InputMismatchException exception){
                System.out.println("Digite apenas números");
            } catch (OpcaoException exception){
                System.err.println(exception.getMessage());
                System.out.println("Digite apenas números de 1 a " + (listProdutos.size()+1));
            }
        }

        String nome = "";
        boolean erroProduto = true;
        while (erroProduto){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome do produto: ");
            nome = scanner.nextLine();
            boolean produtoRepetido = false;
            for (Produto produto : listProdutos){
                if(nome.equalsIgnoreCase(produto.getNome()) && produto.getId() != id){
                    System.out.println("Esse produto já existe. Digite outro nome");
                    produtoRepetido = true;
                    break;
                }
            }
            if (!produtoRepetido)
                erroProduto = false;
        }

        Double preco = 0d;

        boolean erroPreco = true;
        while (erroPreco){
            try{
                Scanner scanner2 = new Scanner(System.in);
                System.out.print("Digite o preço do produto: R$");
                preco = scanner2.nextDouble();
                erroPreco = false;
            } catch (InputMismatchException exception){
                System.out.println("Digite apenas números!");
            }
        }

       for (Produto produto : listProdutos){
           if (produto.getId() == id){
               produto.setNome(nome);
               produto.setPreco(preco);
               break;
           }
       }
        arquivo.escreverArquivo(this.file, listProdutos);



    }

    public void deletarProduto() throws IOException {
        Arquivo arquivo = new Arquivo();
        List<String> dadosEstoque = arquivo.lerArquivo(this.file);
        List<Produto> listProdutos = new LinkedList<>();

        for (String linha : dadosEstoque){
            String[] produtoLinha = linha.split(";");
            Integer idLinha = Integer.parseInt(produtoLinha[0]);
            String nomeLinha = produtoLinha[1];
            Double precoLinha = Double.parseDouble(produtoLinha[2]);
            listProdutos.add(new Produto(idLinha, nomeLinha, precoLinha));
        }

        lerEstoque();

        int id = 0;
        boolean erro = true;
        while(erro){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o número do id do produto para remoção: ");
                id = scanner.nextInt();
                if (id < 1 || id > listProdutos.size() + 1){
                    throw new OpcaoException("Id inválido");
                }
                erro = false;
            } catch (InputMismatchException exception){
                System.out.println("Digite apenas números");
            } catch (OpcaoException exception){
                System.err.println(exception.getMessage());
                System.out.println("Digite apenas números de 1 a " + (listProdutos.size()+1));
            }
        }

        for (Produto produto : listProdutos){
            if(produto.getId() == id){
                listProdutos.remove(produto);
                break;
            }
        }

        arquivo.escreverArquivo(this.file, listProdutos);
    }
}
