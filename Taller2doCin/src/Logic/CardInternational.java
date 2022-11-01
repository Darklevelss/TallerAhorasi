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
        this.minutes+=residue/VALUE_MINUTE;
        this.residue-=minutes*VALUE_MINUTE;
        return this.residue;
    }

    @Override
    public boolean call(short minutes) {
        if(minutes<=this.minutes){
            this.minutes-=minutes;
            return true;}
        return false;
    }
    public float getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(float percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public String toString() {


         return "{ "+this.getNumber()+", "+this.getResidue()+", "+this.getPercentageDiscount()+", "+this.getMinutes()+"}";
    }
}
