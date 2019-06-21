package Ships;

public class SingleShip extends Ship {

    public SingleShip() {
        this.length = 1;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public String getShipType() {
        return "singleship";
    }

}

