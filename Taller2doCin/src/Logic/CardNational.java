package Logic;

public class CardNational extends Card{
    private Operator operator;
    public final double VALUE_MINUTE=20;
    public CardNational(String number,Operator operator) {
        super(number);
    }

    @Override
    public double recharge(double charge) {

        return this.getResidue()+charge;
    }

    @Override
    public boolean call(short minutes) {

        return false;
    }

}
