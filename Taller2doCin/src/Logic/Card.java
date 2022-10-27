package Logic;



public abstract class Card  implements ActionsCard{
    private String number;
    private short minutes;
    private double residue;

    public Card(String number) {

        this.number = number;
        this.minutes=0;
        this.residue=0;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public short getMinutes() {
        return minutes;
    }

    public double getResidue() {
        return residue;
    }
}
