import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*Faça um programa que receba a temperatura média dos 6 primeiros meses do ano e
armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).*/
public class Exercicio1 {
    public static void main(String[] args) {

        List<Double> temperaturas = new ArrayList<>();
        temperaturas.add(30.0);     //janeiro
        temperaturas.add(29.0);     //fevereiro
        temperaturas.add(26.0);     //março
        temperaturas.add(25.4);     //abril
        temperaturas.add(20.9);     //maio
        temperaturas.add(16.6);     //junho

        Double soma = 0d;
        //usando o for
        for(Double temperatura : temperaturas){
            soma += temperatura;
        }

        /*Iterator<Double> iterator = temperaturas.iterator();
        while(iterator.hasNext()){
            soma += iterator.next();
        }*/

        System.out.println(soma);
        System.out.println("Média: " + soma / temperaturas.size());

        Iterator<Double> iterator = temperaturas.iterator();
        while(iterator.hasNext()){
            Double i = iterator.next();
            if (i > soma / temperaturas.size()){
                switch (temperaturas.indexOf(i)) {
                    case 0 -> System.out.println(("Janeiro - " + i));
                    case 1 -> System.out.println(("Fevereiro - " + i));
                    case 2 -> System.out.println(("Março - " + i));
                    case 3 -> System.out.println(("Abril - " + i));
                    case 4 -> System.out.println(("Maio - " + i));
                    case 5 -> System.out.println(("Junho - " + i));
                }
            }
        }


    }
}
