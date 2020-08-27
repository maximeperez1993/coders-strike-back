package fr.mperez.csb.game.car;

import fr.mperez.csb.math.Point;

public class CarBuilder {
    private Point point;
    private int checkpointDistance;
    private int checkpointAngle;

    public CarBuilder setPoint(Point point) {
        this.point = point;
        return this;
    }

    public CarBuilder setCheckpointDistance(int checkpointDistance) {
        this.checkpointDistance = checkpointDistance;
        return this;
    }

    public CarBuilder setCheckpointAngle(int checkpointAngle) {
        this.checkpointAngle = checkpointAngle;
        return this;
    }

    public Car build() {
        return new Car(point, checkpointDistance, checkpointAngle);
    }
}