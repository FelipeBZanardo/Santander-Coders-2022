package felipe;

public class Agenda {
    private Contato contato;
    private String empresa;
    private Telefone telefone;
    private String email;

    public Agenda(Contato contato, Telefone telefone) {
        this.contato = contato;
        this.telefone = telefone;
    }

    public void mostrarAgenda(){
        System.out.println("Nome: " + this.contato.getNome());
        System.out.println("Sobrenome: " + this.contato.getSobrenome());
        System.out.println("Empresa: " + this.empresa);
        System.out.println("felipe.Telefone: " + this.telefone.toString());
    }
}
