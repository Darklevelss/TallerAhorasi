package Runner;

import Logic.*;

import java.util.Arrays;


public class Runner {
    public static void main(String[] args) {
        ServiceCard serviceCard=new ServiceCard();
        serviceCard.addCard(new CardNational("123",Operator.CLARO));
        serviceCard.recharge("123",1000);
        serviceCard.addCard(new CardNational("12",Operator.CLARO));
        serviceCard.addCard(new CardNational("11",Operator.CLARO));
        serviceCard.deleteCard("12");
        System.out.println(Arrays.toString(serviceCard.getCards()));
        System.out.println(serviceCard.deleteCard(""));
    }
    private void menú(){
        System.out.println(">>>>>>menú<<<<<<<" +
                "1.añadir tarjetas " +
                "2.hacer llamadas " +
                "3.borrar tarjetas" +
                "4.salir ");
    }




}
