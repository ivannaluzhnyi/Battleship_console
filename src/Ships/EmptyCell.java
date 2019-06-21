package Ships;

public class EmptyCell extends Ship {

    public EmptyCell() {
        this.length = 1;
    }

    @Override
    public boolean shootAt(int row, int column) {

        this.hit[0] = true;

        return false;
    }

    @Override
    public boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return "-";

    }

    @Override
    public String getShipType() {
        return "emptycell";
    }

    @Override
    public int getLength() {
        return 1;
    }

}

