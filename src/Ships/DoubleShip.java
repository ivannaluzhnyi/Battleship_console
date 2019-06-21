package Ships;

public class DoubleShip extends Ship {

    public DoubleShip() {
        this.length = 2;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public String getShipType() {
        return "doubleship";
    }

}

