package Logic;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ServiceCardTest {
    ServiceCard service=new ServiceCard();
    CardNational cardNational=new CardNational("123",Operator.CLARO);

    void setup(){

        service.addCard(cardNational);


    }

    @org.junit.jupiter.api.Test
    void findCard() {
        setup();
        assertEquals(null,service.findCard("12"));
        assertEquals(cardNational,service.findCard("123"));

    }

    @org.junit.jupiter.api.Test
    void addCard() {
        setup();
        Card[] clone= service.getCards();
        service.addCard(new CardInternational("12",12));
        assertNotEquals(clone,service.getCards());
        assertFalse(service.addCard(new CardInternational("123",1)));
        assertTrue(service.addCard(new CardInternational("1",1)));
    }

    @org.junit.jupiter.api.Test
    void recharge() {
        assertNotEquals(cardNational, service.recharge("123",-1));
        assertEquals(cardNational, service.recharge("123",100000));
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