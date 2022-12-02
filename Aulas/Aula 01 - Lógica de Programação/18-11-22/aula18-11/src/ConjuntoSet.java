import java.util.HashSet;
import java.util.Set;

public class ConjuntoSet {
    public static void main(String[] args) {
        Set<Integer> numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(10);
        numeros.add(1);
        numeros.add(6);
        numeros.add(1);

        Set<Integer> numeros2 = Set.of(1,2,3);

    }
}
