package Ships;

public interface IField {
    public void init();

    void placeAllShipsRandomly();

    boolean isOccupied(int row, int column);
    boolean shootAt(int row, int column);
    int getShotsFired();
    int getHitCount();
    boolean isGameOver();

    Ship[][] getShipArray();

    String toString();


}
