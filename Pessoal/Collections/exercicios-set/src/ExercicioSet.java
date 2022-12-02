import java.util.*;

/*Crie um conjunto contendo as cores do arco-íris e:
* A: Exiba todas as cores uma abaixo da outra
* B: A quantidade de cores que o arco-íris tem
* C: Exiba as cores em ordem alfabética
* D: Exiba as cores na ordem inversa informada
* E: Exiba todas as cores que começam com a letra "v"
* F: Remova todas as cores que não começam com a letra "v"
* G: Limpe o conjunto
* H: Confira se o conjunto está vazio*/
public class ExercicioSet {
    public static void main(String[] args) {
        //Set<String> arcoIris = new TreeSet<>();             //ordem alfabética
        Set<String> arcoIris = new LinkedHashSet<>();               //ordem de inserção
        arcoIris.add("vermelho");
        arcoIris.add("laranja");
        arcoIris.add("amarelo");
        arcoIris.add("verde");
        arcoIris.add("azul");
        arcoIris.add("anil");
        arcoIris.add("violeta");

        System.out.println(arcoIris);

        for (String cor : arcoIris){
            System.out.println(cor);
        }

        System.out.println(arcoIris.size());

        List<String> arcoIrisList = new LinkedList<>(arcoIris);

        for(int i = arcoIrisList.size() - 1; i >= 0; i--){
            System.out.println(arcoIrisList.get(i));
        }

        for(String cor : arcoIris){
            if(cor.charAt(0) == 'v'){
                System.out.println(cor);
            }
        }

        Iterator<String> iterator = arcoIris.iterator();
        while(iterator.hasNext()){
            String i = iterator.next();
            if (i.charAt(0) != 'v'){
                iterator.remove();
            }
        }

        arcoIris.clear();
        System.out.println("Arco-Íris vazio? " + arcoIris.isEmpty());




    }

}
