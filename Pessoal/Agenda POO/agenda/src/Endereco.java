public class Endereco {
    private String cep;
    private Integer numero;

    public Endereco(String cep, Integer numero) {
        this.cep = cep;
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public Integer getNumero() {
        return numero;
    }

}
