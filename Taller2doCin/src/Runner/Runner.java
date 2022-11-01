package Runner;

import Logic.*;

import java.util.Arrays;
import java.util.Random;

public class Runner {


    public static void main(String[] args) {
        ServiceCard service =new ServiceCard();
        System.out.println(service.findCard("123"));
        service.addCard(new CardInternational("123",21));
        System.out.println(service.findCard("123"));
        System.out.println(Arrays.toString(service.getCards()));
        service.addCard(generatorN());
        System.out.println(Arrays.toString(service.getCards()));
        service.addCard(generatorN());
        System.out.println(Arrays.toString(service.getCards()));
    }
    private void menú(){
        System.out.println(">>>>>>menú<<<<<<<" +
                "1.añadir tarjetas " +
                "2.hacer llamadas " +
                "3.borrar tarjetas" +
                "4.salir ");
    }
    public static Card generatorN(){
        Random random=new Random();
        String num= String.valueOf(random.nextInt(1000-1)+1);
        Card generated= new CardNational(num,Operator.CLARO);
        return generated;
    }


    public Card generatorI(){
        Random random=new Random();
        String num= String.valueOf(random.nextInt(1000-1)+1);
        Card generated= new CardInternational(num,21);
        return generated;

    }
}
