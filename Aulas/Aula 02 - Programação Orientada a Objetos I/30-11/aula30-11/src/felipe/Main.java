package felipe;

import felipe.Agenda;
import felipe.Contato;

public class Main {
    public static void main(String[] args) {
        Contato contato = new Contato("Felipe", "Zanardo");
        Telefone telefone = new Telefone(TipoTelefone.CELULAR, 55, 11, "999999999");
        Agenda agenda = new Agenda(contato,telefone);
    }
}
