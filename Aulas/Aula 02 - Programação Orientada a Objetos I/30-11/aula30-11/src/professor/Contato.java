package professor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Contato {
    //atributos:
    public String nome;
    public String sobrenome;
    public String empresa;
    public String email;
    public List<Telefone> telefones;

    public Contato(String nome, String sobrenome, String empresa, String email, List<Telefone> telefones) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.empresa = empresa;
        this.email = email;
        this.telefones = telefones;
    }

    public void removerContato(String numeroAExcluir){
        this.telefones.removeIf(tel -> tel.numero.equals(numeroAExcluir));
    }

    public List<String> listarTelefonesFormatados(){
        return telefones.stream().map(t -> {
            return String.format("%s (%s) %s",t.ddi,t.ddd,t.numero);
        }).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
                "Nome: %s \n" +
                        "Sobrenome: %s \n" +
                        "Empresa: %s \n", nome, sobrenome, empresa
        ));
        sb.append("Telefones\n\n");
        telefones.forEach(telefones -> sb.append(telefones.toString()).append("\n"));
        return sb.toString();
    }
}
