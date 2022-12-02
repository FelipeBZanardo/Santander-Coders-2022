import java.io.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Produto {
    private Integer id;
    private String nome;
    private Double preco;

    public Produto() {
    }

    public Produto (Integer id, String nome, Double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preço= R$" + preco +
                '}';
    }

    /*public Set<Produto> obtemProdutos(List<String> dadosLidos) throws IOException {

        Set<Produto> produtos = new LinkedHashSet<>();

        for (String linha : dadosLidos){
            String[] produtoLinha = linha.split(";");
            Integer idLinha = Integer.parseInt(produtoLinha[0]);
            String nomeLinha = produtoLinha[1];
            Double precoLinha = Double.parseDouble(produtoLinha[2]);
            produtos.add(new Produto(idLinha, nomeLinha, precoLinha));
        }

        return produtos;
    }*/
}
