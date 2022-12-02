public class Main {
    public static void main(StringTeste[] args) {
        Integer numero = 5;
        Double numeroD = numero.doubleValue();

        String numeroS = numero.toString();

        Float numeroF = Float.parseFloat(numeroS);

        numeroS.charAt(0);

        Integer numeroInt = Integer.valueOf(numeroS);

        System.out.println(numeroInt);
    }
}
