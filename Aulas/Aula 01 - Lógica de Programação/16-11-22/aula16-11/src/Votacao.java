import java.util.Arrays;
import java.util.Scanner;

public class Votacao {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();*/

        int[] entradas = {18,70,50,5,15,1,16,17,75};
        String[] saidas = {"Voto obrigatório", "Voto obrigatório", "Voto obrigatório",
                "Sem direito a votar", "Sem direito a votar", "Sem direito a votar",
                "Voto facultativo", "Voto facultativo", "Voto facultativo"};

        String[] saidasObtida = new String[9];

        for (int i = 0; i < entradas.length; i++) {
            saidasObtida[i] = validarVoto(entradas[i]);
            if (saidasObtida[i].equals(saidas[i])){
                System.out.println("Teste " + i + ": OK");
            }else {
                System.out.println("Teste " + i + ": Falhou");
            }
        }

        System.out.println(Arrays.toString(saidasObtida));


    }

    public static String validarVoto(int idade){
        if ((idade >= 16 && idade < 18) || idade > 70){
            return "Voto facultativo";
        } else if(idade >= 18) {
            return "Voto obrigatório";
        } else {
            return "Sem direito a votar";
        }
    }
}
