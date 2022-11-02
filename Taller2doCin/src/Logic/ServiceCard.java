package Logic;


import java.util.Arrays;

public class ServiceCard {
    private  Card []cards;
    private int size;

    /***
     * constructor inicializando el arreglo de cards en 2 de tamaño
     */
    public ServiceCard() {
        this.size=2;
        cards=new Card[size];
    }

    /***
     * metodo que nos permite encontrar una tarjeta por su numero
     * @param number
     * @return null si no existe y la tarjeta si existe
     */
    public Card findCard(String number){

            for (int i = 0; i < cards.length; i++) {
                if (cards[i]!=null&&number.equals(cards[i].getNumber())) {
                    return cards[i];
                }
            }

        return null ;
    }

    /***
     * recibe una tarjeta y la añade al arreglo si esta no existe
     * @param card
     * @return falso si no se pudo añadir, verdadero si se añadió
     */

    public boolean addCard(Card card){
        boolean flagger=true;
        int i;
        if (findCard(card.getNumber())==null){
            for ( i=0;i< cards.length;i++){
                if (cards[i]==null){
                    cards[i]=card;
                    return true;
                }
            }

            if (flagger){
                int oldLength= cards.length;
            int newCapacity= cards.length+(cards.length/2);
            cards=Arrays.copyOf(cards,newCapacity);
            cards[oldLength]=card;
                return true;
            }
        }
        return false;

    }

    /***
     * sirve para hacer una recarga
     * @param number el numero de la tarjeta
     * @param value el valor de la recarga
     * @return la tarjeta si se encontró y el valor es valido, null si no
     */
    public Card recharge(String number,double value){
        if (value>=0){
        if (findCard(number)!=null){
            findCard(number).recharge(value);
            return findCard(number);
        }
        }
        return null;}

    /**
     * método de llamada que verifica
     * @param number
     * @param minutes
     * @return true si se pudo concretar la llamada, false sino
     */
    public boolean call(String number,short minutes){
        if(minutes>=0&&findCard(number)!=null){
            findCard(number).call(minutes);
            return true;
        }
        return false;}

    /**
     * sirve para ver las tarjetas
     * @return un clon
     */
    public Card[] getCards(){
        Card[] clone=cards.clone();
        return clone ;}

    /***
     * sirve para eliminar las tarjetas con un numero
     * @param number numero de la tarjeta
     * @return la tarjeta removida sino null
     */
    public Card deleteCard(String number) {

        for (int i = 0; i < cards.length; i++)
            if (number.equalsIgnoreCase(cards[i].getNumber())) {
                Card removed = cards[i];
                cards[i] = null;
                for (int j = i; j < cards.length-1; j++) {
                    cards[j] = cards[j + 1];
                }
                cards=Arrays.copyOf(cards,cards.length-1);

                return removed;
            }

        return null;
    }
}