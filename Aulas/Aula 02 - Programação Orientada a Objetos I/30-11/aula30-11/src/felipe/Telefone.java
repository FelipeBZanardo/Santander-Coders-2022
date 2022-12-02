package felipe;

public class Telefone {
    private TipoTelefone tipoTelefone;
    private int ddi;
    private int ddd;
    private String numero;

    public Telefone(TipoTelefone tipoTelefone, int ddi, int ddd, String numero) {
        this.tipoTelefone = tipoTelefone;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    @Override
    public String toString() {
        return "" + this.tipoTelefone + " " + this.ddi + " " + this.ddd + " " + this.numero;
    }

    public int getDdi() {
        return ddi;
    }

    public int getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
