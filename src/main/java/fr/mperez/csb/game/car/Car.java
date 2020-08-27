package fr.mperez.csb.game.car;

import fr.mperez.csb.math.Point;

public class Car {

    private final Point point;
    private final int checkpointDistance;
    private final int checkpointAngle;

    public Car(Point point, int checkpointDistance, int checkpointAngle) {
        this.point = point;
        this.checkpointDistance = checkpointDistance;
        this.checkpointAngle = checkpointAngle;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public int distance() {
        return checkpointDistance;
    }

    public int angle() {
        return checkpointAngle;
    }


}
