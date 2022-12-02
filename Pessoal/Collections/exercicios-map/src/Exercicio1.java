import java.lang.management.ManagementPermission;
import java.util.*;

/*Dada a população estimada de alguns estados, faça:
* Estado = PE - População = 9616621
* Estado = AL - População = 3351543
* Estado = CE - População = 9187103
* Estado = RN - População = 3534265
*
* - Crie um dicionário e relacione os estados e suas populações;
* - Substitua a população do estado do RN por 3534165
* - Confira se o estado PB está no dicionário, caso não, adicione 4039277
* - Exiba todos os estados e suas populações na ordem que foi informado
* - Exiba os estados e suas populações em ordem alfabética
* - Exiba o estado com a menor população e sua quantidade
* - Exiba o estado com a maior população e sua quantidade
* - Exiba a soma da população desses estados
* - Exiba a média da população deste dicionário de estados
* - Remova os estados com a população menor que 4000000
* - Apague o dicionário de estados
* - Confira se o dicionário está vazio*/
public class Exercicio1 {
    public static void main(String[] args) {

        //Map<Estados, Integer> estados = new LinkedHashMap<>();          //ordem de inserção das chaves
        Map<Estados, Integer> estados = new TreeMap<>();                  //ordem alfabéticas das chaves
        estados.put(Estados.PE, 9616621);
        estados.put(Estados.AL, 3351543);
        estados.put(Estados.CE, 9187103);
        estados.put(Estados.RN, 3534265);

        estados.replace(Estados.RN, 3534165);

        if (!estados.containsKey(Estados.PB))
            estados.put(Estados.PB, 4039277);

        Integer menorPopulacao = Collections.min(estados.values());
        Integer maiorPopulacao = Collections.max(estados.values());

        for (Map.Entry<Estados, Integer> estado : estados.entrySet()){
            if (estado.getValue().equals(menorPopulacao)){
                System.out.println("Estado com menor população: " + estado.getKey());
            }
        }
        for (Map.Entry<Estados, Integer> estado : estados.entrySet()){
            if (estado.getValue().equals(maiorPopulacao)){
                System.out.println("Estado com maior população: " + estado.getKey());
            }
        }

        Integer totalPopulacao = 0;
        for (Integer populacao : estados.values()){
            totalPopulacao += populacao;
        }

        System.out.println("Soma da população em todos os estados: " + totalPopulacao);
        System.out.println("Média da população nos estados: " + totalPopulacao * 1.0 / estados.size());

        //não é possível utilizar essa técnica para remover elementos
       /* for(Map.Entry<Estados, Integer> estado : estados.entrySet()){
            if (estado.getValue() < 4000000){
                estados.remove(estado.getKey());
            }
        }*/

        Iterator<Integer> iterator = estados.values().iterator();
        while (iterator.hasNext()){
            Integer populacao = iterator.next();
            if(populacao < 4000000)
                iterator.remove();
        }

        estados.clear();
        System.out.println("Map vazio: " + estados.isEmpty());



        System.out.println(estados);
    }
}
