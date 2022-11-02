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