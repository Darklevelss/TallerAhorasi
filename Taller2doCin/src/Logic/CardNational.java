package Logic;

public class CardNational extends Card{
    private Operator operator;
    public final static double VALUE_MINUTE=20;
    public CardNational(String number,Operator operator) {
        super(number);
        this.operator=operator;
    }

    @Override
    public double recharge(double charge) {
        this.residue+=charge+(charge*0.25);
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

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "{ "+this.getNumber()+", "+this.getResidue()+", "+this.getOperator()+", "+this.getMinutes()+"}";
    }
}
