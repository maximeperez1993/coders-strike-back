package fr.mperez.csb;

import fr.mperez.csb.game.car.Car;

public class TurnState {
    private final Car[] myCars;
    private final Car[] hisCars;

    public TurnState(Car[] myCars, Car[] hisCars) {
        this.myCars = myCars;
        this.hisCars = hisCars;
    }

    public Car[] getMyCars() {
        return myCars;
    }

    public Car[] getHisCars() {
        return hisCars;
    }
}
