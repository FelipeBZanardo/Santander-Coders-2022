package professor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Telefone> telefones = new ArrayList<>();

        //contato.nome = "Felipe";
        //contato.sobrenome = "Zanardo";

        Telefone telefone1 = new Telefone(TipoTelefone.CELULAR, "+55", "011", "999999999");
        /*telefone1.tipoTelefone = TipoTelefone.CELULAR;
        telefone1.ddi = "+55";
        telefone1.ddd = "11";
        telefone1.numero = "999999999";*/

        telefones.add(telefone1);

        Telefone telefone2 = new Telefone(TipoTelefone.RESIDENCIAL, "+55", "011", "888888888");
        /*telefone2.tipoTelefone = TipoTelefone.RESIDENCIAL;
        telefone2.ddi = "+55";
        telefone2.ddd = "11";
        telefone2.numero = "888888888";*/

        telefones.add(telefone2);

        Contato contato1 = new Contato("Felipe", "Zanardo", "ada",
                "felipe@felipe", telefones);

        //System.out.println(contato1.toString());
        //System.out.println(contato.nome);
        //contato.telefones.forEach(tel -> System.out.println(tel.toString()));

        //contato.removerContato("888888888");

        //contato.listarTelefonesFormatados().forEach(System.out::println);

        List<Contato> contatos = new ArrayList<>();
        contatos.add(contato1);

        Agenda agenda = new Agenda(contatos);


    }
}
