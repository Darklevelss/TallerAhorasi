package Logic;


import java.util.Arrays;

public class ServiceCard {
    private  Card []cards;
    private int size;

    public ServiceCard() {
        this.size = 0;
    }
    public Card findCard(String number){
        for(int i=0;i<cards.length;i++){
            if (number.equalsIgnoreCase(cards[i].getNumber())){
                return cards[i];
            }
        }

        return null ;
    }
    public boolean addCard(Card card){
        int i;
       for(i=0;i<cards.length;i++){
           if (card.getNumber().equalsIgnoreCase(cards[i].getNumber())){
              return false;
           }
       }
        cards=Arrays.copyOf(cards, cards.length + (cards.length / 3));
        cards[i++]=card;

        return true;

    }
    public Card recharge(String number,double value){
        if (value>=0){
        for(int i=0;i<cards.length;i++){
            if(cards[i].getNumber().equals(number)) {
                cards[i].recharge(value);
            }
        }
        }
        return null;}
    public boolean call(String number,short minutes){return false;}
    public Card[] getCards(){return null;}
    public Card deleteCard(String number){
        Card deletedCard=null;
        for (var i=0;i<cards.length;i++){

            if(cards[i].getNumber().equals(number)){
                deletedCard=cards[i];
                for (var j=i;j< cards.length;j++){
                    cards[i]=cards[i++];
                }

            }
        }

        return deletedCard;}
}
