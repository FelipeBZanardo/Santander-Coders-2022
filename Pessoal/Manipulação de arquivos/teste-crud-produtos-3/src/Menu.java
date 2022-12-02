import java.util.ArrayList;
import java.util.List;

public class Menu {

    public void iniciarMenuPrincipal(){
        System.out.println("""
                *********Menu CRUD PRODUTOS*********
                
                1 - Selecionar arquivo de estoque
                2 - Criar novo Produto - CREATE
                3 - Ler estoque de Produtos - READE
                4 - Atualizar Produto - UPDATE
                5 - Remover Produto - DELETE
                6 - Encerrar Programa
                """);

        Arquivo arquivo = new Arquivo();
        List<String> dadosArquivo = new ArrayList<>();

        switch (EntradaDados.obterOpcao(6)){
            case 1:
                arquivo = EntradaDados.obterArquivo();
                iniciarMenuPrincipal();
                break;
            case 3:
                dadosArquivo = arquivo.lerArquivo();
                System.out.println(dadosArquivo);
                break;
        }
    }

}
