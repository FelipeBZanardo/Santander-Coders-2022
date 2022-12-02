package aula3.versao_desacoplada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MaquinaVendas {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean loop = true;
        ItensParaVenda produto;

        while (loop) {
            System.out.println("""
                    ============================
                    ==== Consulta de Preços ====
                    ============================
                    """);
            System.out.println("Entre com o número de um item para consulta: ");

            for (ItensParaVenda item : ItensParaVenda.values()) {
                System.out.println((item.ordinal() + 1) + " - " + item.getNome());
            }

            try {
                System.out.print("\n> ");
                int itemEscolhido = input.nextInt();
                produto = ItensParaVenda.values()[itemEscolhido - 1];
                System.out.printf("%nO preço do item %s é R$ %.2f.%n%n", produto.getNome(), produto.getValor());

            } catch (InputMismatchException | ArrayIndexOutOfBoundsException ex) {
                System.out.printf("""
                        \u001B[31m
                                                
                        >>> Deve informar um número inteiro entre 1 e %d! <<<
                                               
                        \u001B[0m""", ItensParaVenda.values().length);
            }
            input.nextLine();
            System.out.println("Entre <s> para uma nova consulta.");
            String novaConsulta = input.nextLine();
            if (!novaConsulta.equalsIgnoreCase("s")) loop = false;
        }
        input.close();
    }
}
