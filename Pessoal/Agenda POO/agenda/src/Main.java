public class Main {
    public static void main(String[] args) {

        String nomeContato = "Felipe";
        String numeroTelefone = "1199999999";
        Telefone tipoTelefone = Telefone.CELULAR;
        PessoaFisica felipe = new PessoaFisica(nomeContato);
        felipe.setEndereco(new Endereco("000000001", 10));
        felipe.setNumeroDocumeto("4000000000");
        Agenda agenda = new Agenda(felipe, tipoTelefone, numeroTelefone);
        agenda.imprimirContato();

    }
}
