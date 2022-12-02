import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lista {
    public static void main(String[] args) {
       List<Integer> lista = new ArrayList<>();
       List<Integer> lista2 = Arrays.asList(1,2,3);             //lista imutável
        List<Integer> lista3 = List.of(1,2,3);                  //lista imutávellista.add(1);
       lista.add(-1);
       lista.add(15);
       lista.add(18);
       lista.add(8);
       lista.add(100);


        System.out.println(lista.get(2));
        lista.forEach(a -> System.out.println(a));


    }
}
