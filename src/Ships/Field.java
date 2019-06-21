package Ships;

import Factories.ShipFactory;

import Arrays.ArrayList;

import java.util.Random;

public class Field implements IField {

    public static final int GRID_SIZE = 10;

    private static final int QUATTER_NO = 1;
    private static final int TRIPLE_NO = 2;
    private static final int DOUBLE_NO = 3;
    private static final int SINGLE_NO = 4;

    private final Ship[][] gameBoard;
    private final boolean[][] locationsFiredUpon;

    private final ShipFactory shipFactory;

    private ArrayList<Ship> ships;

    private int shotsFired;
    private int hitsRecorded;
    private int shipsSunk;
    private int totalShips;

    public Field() {

        shipFactory = ShipFactory.getInstance();
        this.gameBoard = new Ship[GRID_SIZE][GRID_SIZE];
        this.locationsFiredUpon = new boolean[GRID_SIZE][GRID_SIZE];

    }

    public void init() {

        this.shotsFired = 0;
        this.hitsRecorded = 0;
        this.shipsSunk = 0;
        totalShips = 0;

        initializeShipArray();
        buildShips();

    }
    private void setShip(Ship ship)
    {
        this.ships.add(ship);
    }

    private void initializeShipArray() {

        for (int row = 0; row < this.gameBoard.length; row++) {
            for (int col = 0; col < this.gameBoard[row].length; col++) {
                this.gameBoard[row][col] = shipFactory.getShip("emptycell");
                this.locationsFiredUpon[row][col] = false;
            }
        }

    }

    private void buildShips() {

        ships = new ArrayList();

        for (int i = 0; i < QUATTER_NO; i++) {
            this.setShip(shipFactory.getShip("quattership"));
            totalShips++;
        }

        for (int i = 0; i < TRIPLE_NO; i++) {
            this.setShip(shipFactory.getShip("tripleship"));
            totalShips++;
        }

        for (int i = 0; i < DOUBLE_NO; i++) {
            this.setShip(shipFactory.getShip("doubleship"));
            totalShips++;
        }

        for (int i = 0; i < SINGLE_NO; i++) {
            this.setShip(shipFactory.getShip("singleship"));
            totalShips++;
        }

    }

    public void placeAllShipsRandomly()
    {
        boolean valid_position = false;
        int row = 0;
        int column = 0;
        boolean horizontal = false;

        Random random = new Random();

        for(int i = 0; i < this.ships.size(); i++){

            while (!valid_position) {
                row = random.nextInt(GRID_SIZE);
                column = random.nextInt(GRID_SIZE);
                horizontal = random.nextBoolean();
                valid_position = ships.get(i).okToPlaceShipAt(row, column, horizontal, this);
            }

            ships.get(i).placeShipAt(row, column, horizontal, this);
            valid_position = false;

        }

    }

    public boolean isOccupied(int row, int column) {
        return !(this.gameBoard[row][column] instanceof EmptyCell);
    }

    public boolean shootAt(int row, int column) {

        this.shotsFired++;
        this.locationsFiredUpon[row][column] = true;

        boolean isOccupied = isOccupied(row, column);

        Ship shipAtPosition = this.gameBoard[row][column];

        if (shipAtPosition.isSunk()) {
            return false;
        }

        boolean shipHit = shipAtPosition.shootAt(row, column);

        if (isOccupied) {

            if (shipHit) {
                this.hitsRecorded++;
            }

            if (shipAtPosition.isSunk()) {
                shipsSunk++;
            }

        }

        return shipHit;

    }

    public int getShotsFired() {
        return this.shotsFired;
    }

    public int getHitCount() {
        return this.hitsRecorded;
    }

    public int getShipsSunk() {
        return this.shipsSunk;
    }

    public boolean isGameOver() {
        return (this.shipsSunk == totalShips);
    }

    public Ship[][] getShipArray() {
        return gameBoard;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        int rowCount = 0;
        int columnCount;

        String newLine = "\n";
        String blank = " ";

        result.append("!");

        for (columnCount = 0; columnCount < gameBoard.length; columnCount++) {
            result.append(blank).append(columnCount);
        }

        result.append(newLine);

        for (Ship[] row : gameBoard) {

            result.append(rowCount);
            columnCount = 0;
            for (Ship shipAtColumn : row) {
                if (this.locationsFiredUpon[rowCount][columnCount]) {
                    result.append(blank).append(shipAtColumn.toString());
                } else {
                    result.append(blank).append(".");
                }
                ++columnCount;
            }
            ++rowCount;
            result.append(newLine);
        }

        return result.toString();

    }

}

