public class Teste {
    public static void main(String[] args) {
        soneca(5);
    }

    private static void soneca(int segundos) {
        System.out.println("Falta(m) " + segundos + " segundos");

    }

    private static void soneca(int minutos, int segundos){
        System.out.println("Falta(m) " + minutos + " minutos");
        soneca(segundos);
    }
}
