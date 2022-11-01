package Logic;


import java.util.Arrays;

public class ServiceCard {
    private  Card []cards;
    private int size;

    public ServiceCard() {
        this.size=2;
        cards=new Card[size];
    }

    public Card findCard(String number){

            for (int i = 0; i < cards.length; i++) {
                if (cards[i]!=null&&number.equals(cards[i].getNumber())) {
                    return cards[i];
                }
            }

        return null ;
    }
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
    public Card recharge(String number,double value){
        if (value>=0){
        if (findCard(number)!=null){
            findCard(number).recharge(value);
        }
        }
        return null;}
    public boolean call(String number,short minutes){
        if(minutes>=0&&findCard(number)!=null){
            findCard(number).call(minutes);
            return true;
        }
        return false;}
    public Card[] getCards(){
        Card[] clone=cards.clone();
        return clone ;}
    public Card deleteCard(String number){
        Card deletedCard=null;
        int pos;
        Card[]newArr;
       /* for (var i=0;i<cards.length;i++){
            if(cards[i].getNumber().equalsIgnoreCase(number)){
                deletedCard=cards[i];

            }
        }*/
        for (int i=0;i< cards.length;i++) {
            if (cards[i].getNumber().equalsIgnoreCase(number)) {

                Card[] arrDestination = new Card[cards.length - 1];
                int remainingElements = cards.length - (i + 1);
                System.arraycopy(cards, 0, arrDestination, 0, i);
                System.arraycopy(cards, i + 1, arrDestination, i, remainingElements);
            }
        }
        return deletedCard;}

}
