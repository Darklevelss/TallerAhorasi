package Logic;

public class CardInternational extends Card{

    private final double VALUE_MINUTE=25;
    private float percentageDiscount;

    /***
     *
     * @param number
     * @param percentageDiscount se inicia el porcentaje de descuento del
     */
    public CardInternational(String number,float percentageDiscount) {
        super(number);
        this.percentageDiscount=percentageDiscount;
    }

    /***
     * sirve para hcer una recarga
     * @param charge el valor de la recarga en pesos
     * @return
     */
    @Override
    public double recharge(double charge) {
        this.residue+=charge;
        this.minutes+=residue/VALUE_MINUTE;
        this.residue-=minutes*VALUE_MINUTE;
        return this.residue;
    }

    @Override
    /***
     *
     * @param minutes minutos
     */
    public boolean call(short minutes) {
        if(minutes<=this.minutes){
            this.minutes-=minutes-(minutes*percentageDiscount);
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
