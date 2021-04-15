package fr.mperez.csb;

import fr.mperez.csb.game.car.Car;
import fr.mperez.csb.game.checkpoint.Checkpoint;

public class TurnState {
    private final Car myCar;
    private final Car hisCar;
    private final Checkpoint nextCheckpoint;

    public TurnState(Car myCar, Car hisCar, Checkpoint nextCheckpoint) {
        this.myCar = myCar;
        this.hisCar = hisCar;
        this.nextCheckpoint = nextCheckpoint;
    }

    public Car myCar() {
        return myCar;
    }

    public Car hisCar() {
        return hisCar;
    }

    public Checkpoint nextCheckpoint() {
        return nextCheckpoint;
    }

}
