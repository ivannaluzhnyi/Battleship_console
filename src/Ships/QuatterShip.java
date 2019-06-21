package Ships;

public class QuatterShip extends Ship {

    public QuatterShip() {
        this.length = 4;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public String getShipType() {
        return "quattership";
    }

}