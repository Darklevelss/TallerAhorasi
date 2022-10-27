package Logic;

public class CardInternational extends Card{

    private final double VALUE_MINUTE=25;
    private float percentageDiscount;
    public CardInternational(String number,float percentageDiscount) {
        super(number);
    }

    @Override
    public double recharge(double charge) {

        return 0;
    }

    @Override
    public boolean call(short minutes) {
        return false;
    }
    public float getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(float percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

}
