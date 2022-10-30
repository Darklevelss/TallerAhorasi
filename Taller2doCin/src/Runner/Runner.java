package Runner;

import Logic.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        ServiceCard service =new ServiceCard();
        System.out.println(service.findCard("123"));
        service.addCard(new CardInternational("123",21));
        System.out.println(service.findCard("123"));
    }
    private void menú(){
        System.out.println(">>>>>>menú<<<<<<<" +
                "1.añadir tarjetas " +
                "2.hacer llamadas " +
                "3.borrar tarjetas" +
                "4.salir ");
    }
}
