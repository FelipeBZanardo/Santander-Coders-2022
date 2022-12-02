import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] numeros = new int[3];
        numeros[0] = 1;
        numeros[1] = 10;
        numeros[2] = 5;

        Arrays.sort(numeros);
        /*for(int numero : numeros) {
            System.out.println(numero);
        }*/

        System.out.println(Arrays.toString(numeros));

        System.out.println(Arrays.binarySearch(numeros, 5));

    }
}
