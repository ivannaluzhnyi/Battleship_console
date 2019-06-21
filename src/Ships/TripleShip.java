package Ships;

public class TripleShip extends Ship {

    public TripleShip() {
        this.length = 3;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public String getShipType() {
        return "tripleship";
    }


}
