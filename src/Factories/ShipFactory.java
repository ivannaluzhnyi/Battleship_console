package Factories;
import Ships.EmptyCell;
import Ships.SingleShip;
import Ships.DoubleShip;
import Ships.QuatterShip;
import Ships.TripleShip;
import Ships.Ship;

public class ShipFactory implements IShipFactory {

    private static ShipFactory shipFactory;

    private ShipFactory() {
    }

    public static ShipFactory getInstance() {

        if (shipFactory == null) {
            shipFactory = new ShipFactory();
        }
        return shipFactory;

    }

    public Ship getShip(String name) {

        switch (name) {

            case "singleship":
                return new SingleShip();
            case "doubleship":
                return new DoubleShip();
            case "tripleship":
                return new TripleShip();
            case "quattership":
                return new QuatterShip();
            default:
                return new EmptyCell();

        }

    }

}
