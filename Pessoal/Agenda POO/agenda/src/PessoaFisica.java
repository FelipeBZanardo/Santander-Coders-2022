public class PessoaFisica extends Pessoa{

    private final Documento tipoDocumento = Documento.CPF;
    private String numeroDocumeto;
    public PessoaFisica(String nome) {
        super(nome);
    }

    public Documento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumeto() {
        return numeroDocumeto;
    }

    public void setNumeroDocumeto(String numeroDocumeto) {
        this.numeroDocumeto = numeroDocumeto;
    }
}
