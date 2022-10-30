package Logic;

public class CardInternational extends Card{

    private final double VALUE_MINUTE=25;
    private float percentageDiscount;
    public CardInternational(String number,float percentageDiscount) {
        super(number);
        this.percentageDiscount=percentageDiscount;
    }

    @Override
    public double recharge(double charge) {
        this.residue+=charge;
        return this.residue;
    }

    @Override
    public boolean call(short minutes) {
        this.residue-=minutes*VALUE_MINUTE;
        this.minutes+=minutes;
        return true;
    }
    public float getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(float percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

}
