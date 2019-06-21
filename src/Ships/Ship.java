package Ships;

public abstract class Ship implements IShip {

    public final boolean[] hit = {false, false, false, false, false};
    public int length;
    private int bowColumn;
    private int bowRow;
    private boolean isHorizontal;

    public abstract int getLength();

    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int row) {
        bowRow = row;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int column) {
        bowColumn = column;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    public abstract String getShipType();

    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Field field) {
        Ship[][] grid = field.getShipArray();

        if (!(grid[row][column] instanceof EmptyCell)) {
            return false;
        }

        if (this.shipsAreAdjacent(row, column, grid)) {
            return false;
        }

        if (horizontal) {
            if ((column + this.length) > grid.length - 1) {
                return false;
            }
            for (int i = 1; i < this.length; i++) {
                if (!(grid[row][column + i] instanceof EmptyCell)) {
                    return false;
                }
                if (this.shipsAreAdjacent(row, column + i, grid)) {
                    return false;
                }
            }
        } else {
            if ((row + this.length) > grid.length - 1) {
                return false;
            }
            for (int i = 1; i < this.length; i++) {
                if (!(grid[row + i][column] instanceof EmptyCell)) {
                    return false;
                }
                if (this.shipsAreAdjacent(row + i, column, grid)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean shipsAreAdjacent(int row, int column, Ship[][] grid) {
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
    }

    public void placeShipAt(int row, int column, boolean horizontal, Field ocean) {
        this.setBowColumn(column);
        this.setBowRow(row);
        this.setHorizontal(horizontal);

        Ship[][] grid = ocean.getShipArray();

        int shipLength = this.getLength();

        for (int i = 0; i < shipLength; i++) {
            if (horizontal) {
                grid[row][column + i] = this;
            } else {
                grid[row + i][column] = this;
            }
        }
    }

    public boolean shootAt(int row, int column) {
        if (this.isHorizontal) {
            if (this.bowRow != row) {
                return false;
            }
            for (int i = 0; i < this.length; i++) {
                if ((this.bowColumn + i) == column) {
                    this.registerHit(i);
                    return true;
                }
            }
        } else {
            if (this.bowColumn != column) {
                return false;
            }
            for (int i = 0; i < this.length; i++) {
                if ((this.bowRow + i) == row) {
                    this.registerHit(i);
                    return true;
                }
            }
        }

        return false;
    }

    private void registerHit(int index) {
        this.hit[index] = true;
    }

    public boolean isSunk() {
        for (int i = 0; i < this.length; i++) {
            if (!this.hit[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.isSunk()) {
            return "x";
        }
        return "A";
    }

}

