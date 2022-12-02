public class PessoaJuridica extends Pessoa{

    Documento tipoDocumento = Documento.CNPJ;
    private String numeroDocumeto;

    public PessoaJuridica(String nome) {
        super(nome);
    }

    public Documento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Documento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumeto() {
        return numeroDocumeto;
    }

    public void setNumeroDocumeto(String numeroDocumeto) {
        this.numeroDocumeto = numeroDocumeto;
    }
}
