package Factories;

import Ships.Ship;

public interface IShipFactory {
    Ship getShip(String name);
}
