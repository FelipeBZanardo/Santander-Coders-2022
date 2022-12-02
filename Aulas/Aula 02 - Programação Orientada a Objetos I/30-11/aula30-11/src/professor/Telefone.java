package professor;

public class Telefone {
    public TipoTelefone tipoTelefone;
    public String ddi;
    public String ddd;
    public String numero;

    public Telefone(TipoTelefone tipoTelefone, String ddi, String ddd, String numero) {
        this.tipoTelefone = tipoTelefone;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return String.format(
                "Tipo: %s \n" +
                "DDI: %s \n" +
                "DDD: %s \n" +
                "Número %s \n\n", tipoTelefone, ddi, ddd, numero);
    }
}
