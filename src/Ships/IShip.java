package Ships;

public interface IShip {

    abstract int getLength();
    int getBowRow();
    void setBowRow(int row);
    int getBowColumn();
    void setBowColumn(int column);

    boolean isHorizontal();
    void setHorizontal(boolean horizontal);

    abstract String getShipType();

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Field field);
    private boolean shipsAreAdjacent(int row, int column, Ship[][] grid){
        int[] increments = {-1, 0, 1};

        for (int incrementRow : increments) {
            for (int incrementColumn : increments) {

                int rowToTest = row + incrementRow;
                int columnToTest = column + incrementColumn;
                try {
                    if (!(grid[rowToTest][columnToTest] instanceof EmptyCell)) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }

        return false;
    };

    void placeShipAt(int row, int column, boolean horizontal, Field ocean);

    boolean shootAt(int row, int column);

    boolean isSunk();
    String toString();

}
