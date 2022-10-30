package Logic;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ServiceCardTest {
    ServiceCard service=new ServiceCard();


    void setup(){

        service.addCard(new CardNational("123",Operator.CLARO));


    }

    @org.junit.jupiter.api.Test
    void findCard() {
        setup();

    }

    @org.junit.jupiter.api.Test
    void addCard() {

    }

    @org.junit.jupiter.api.Test
    void recharge() {
    }

    @org.junit.jupiter.api.Test
    void call() {
    }

    @org.junit.jupiter.api.Test
    void getCards() {
    }

    @org.junit.jupiter.api.Test
    void deleteCard() {
    }
}