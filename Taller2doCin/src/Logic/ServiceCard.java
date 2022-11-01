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

        if (findCard(card.getNumber())==null){
            for (int i=0;i< cards.length;i++){
                if (cards[i]==null){
                    cards[i]=card;
                }
                else if(i> cards.length-2){
                    int newCapacity= cards.length+(cards.length/2);
                    cards=Arrays.copyOf(cards,newCapacity);
                    cards[i+1]=card;
                }
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
