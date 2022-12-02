import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Estoque {
    private Arquivo arquivo;

    private Set<Produto> listaProdutos = new LinkedHashSet<>();

    public Estoque(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public Set<Produto> obterListaProdutos (Set<String> dadosLidos){

        if (dadosLidos.size() != 0){
            for (String linha : dadosLidos){
                String[] produtos = linha.split(";");
                String nome = produtos[0];
                int quantidade = 0;
                double preco = 0d;
                try {
                    quantidade = Integer.parseInt(produtos[1]);
                    preco = Double.parseDouble(produtos[2]);
                } catch (InputMismatchException | NumberFormatException exception){
                    System.out.println("\u001B[31mArquivo de Estoque danificado\u001B[0m");
                    System.exit(0);
                }
                listaProdutos.add(new Produto(nome, quantidade, preco));
            }
        }

        return this.listaProdutos;
    }

    public void imprimirEstoque(){

        if (this.listaProdutos.size() == 0){
            System.out.println("\u001B[31mEstoque vazio!\u001B[0m");
        } else{
            System.out.println("\n****\tESTOQUE DE PRODUTOS\t****");
            System.out.println("====================================================");
            System.out.printf("%-20s %-20s %-20s\n",
                    "Produto", "Quantidade", "Preço(R$)");

            for(Produto produto : this.listaProdutos){
                System.out.printf("%-20s %-20d %-20.2f\n",
                        produto.getNome(), produto.getQuantidade(), produto.getPreco());
            }
        }
    }

    public void removerProduto(){

        if(this.listaProdutos.size() == 0){
            System.out.println("\u001B[31mNão há produtos a remover\u001B[0m");
            return;
        }

        String nomeProdutoExclusao = EntradaDados.receberNomeProdutoAtualizacao(this);
        try{
            this.listaProdutos.remove(obterProduto(nomeProdutoExclusao));
            this.arquivo.escreverArquivo(this.listaProdutos);
        } catch (NullPointerException exception){
            System.out.println("\u001B[31mProduto não encontrado\u001B[0m");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificarProduto(String nome){
        for (Produto produto : this.listaProdutos){
            if (produto.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    public Produto obterProduto(String nome){
        for (Produto produto : this.listaProdutos){
            if (produto.getNome().equals(nome)){
                return produto;
            }
        }
        return null;
    }

    public void adicionarProduto() throws IOException {
        String nome = EntradaDados.receberNomeProduto(this);
        int quantidade = EntradaDados.receberQuantidadeProduto(this);
        double preco = EntradaDados.receberPrecoProduto(this);

        this.listaProdutos.add(new Produto(nome, quantidade, preco));
        this.arquivo.escreverArquivo(this.listaProdutos);
    }

    public void atualizarNome() throws IOException {
        if(this.listaProdutos.size() == 0){
            System.out.println("\u001B[31mNão há produtos a atualizar\u001B[31m");
            return;
        }
        String nomeAntigo = EntradaDados.receberNomeProdutoAtualizacao(this);
        String nomeNovo = EntradaDados.receberNomeProduto(this);
        Produto produto = this.obterProduto(nomeAntigo);
        produto.setNome(nomeNovo);
        this.listaProdutos.add(produto);
        this.arquivo.escreverArquivo(this.listaProdutos);
    }

    public void atualizarQuantidade() throws IOException {
        if(this.listaProdutos.size() == 0){
            System.out.println("\u001B[31mNão há produtos a atualizar\u001B[31m");
            return;
        }
        String nomeAntigo = EntradaDados.receberNomeProdutoAtualizacao(this);
        int quantidade = EntradaDados.receberQuantidadeProduto(this);
        Produto produto = this.obterProduto(nomeAntigo);
        produto.setQuantidade(quantidade);
        this.listaProdutos.add(produto);
        this.arquivo.escreverArquivo(this.listaProdutos);
    }

    public void atualizarPreco() throws IOException {
        if(this.listaProdutos.size() == 0){
            System.out.println("\u001B[31mNão há produtos a atualizar\u001B[31m");
            return;
        }
        String nomeAntigo = EntradaDados.receberNomeProdutoAtualizacao(this);
        double preco = EntradaDados.receberPrecoProduto(this);
        Produto produto = this.obterProduto(nomeAntigo);
        produto.setPreco(preco);
        this.listaProdutos.add(produto);
        this.arquivo.escreverArquivo(this.listaProdutos);
    }
}
