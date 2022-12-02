/*Faça um programa, que solicite ao usuário que informe o mês
e o sistema deve imprimir o valor gasto do mês.
->Considerações:
Utilizar enum
Criar um valor para cada mês*/

import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean erro = true;
        do {
            System.out.print("Digite um mês: ");
            String mesEntrada = scanner.nextLine().toUpperCase().trim();

            /*for (Ano mes : Ano.values()) {
                if (mes.name().equals(mesEntrada)) {
                    erro = false;
                    break;
                }
            }

            if (erro)
                System.out.println("Digite um mês válido!!!");
            else
                System.out.printf("O gasto do mês de %s é de R$%.2f",
                        Ano.valueOf(mesEntrada), Ano.valueOf(mesEntrada).getValor());*/

            try{
                double gasto = Ano.valueOf(mesEntrada).getValor();
                System.out.printf("O gasto do mês de %s é de R$%.2f",
                        mesEntrada, Ano.valueOf(mesEntrada).getValor());
                erro = false;
            } catch (IllegalArgumentException exception){
                System.err.println(exception.getMessage());
                System.out.println("Esse mês não existe!");
            }
        } while (erro);



    }
}
