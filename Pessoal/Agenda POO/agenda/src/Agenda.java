public class Agenda {
    private Pessoa pessoa;
    private String email;
    private Telefone tipoTelefone;

    private String numeroTelefone;

    public Agenda(Pessoa pessoa, Telefone tipoTelefone, String numeroTelefone) {
        this.pessoa = pessoa;
        this.tipoTelefone = tipoTelefone;
        this.numeroTelefone = numeroTelefone;
    }

    public void imprimirContato(){
        System.out.println("Nome: " + this.pessoa.getNome());
        System.out.println("Documento: " + this.pessoa.getDocumento());
        System.out.print("CEP: " + this.pessoa.getEndereco().getCep());
        System.out.println("\tnúmero: " + this.pessoa.getEndereco().getNumero());
        System.out.println("E-mail: " + this.email);
        System.out.println("Telefone: " + this.tipoTelefone + "\t" + this.numeroTelefone);

    }
}
