package fr.mperez.csb.game.car;

import fr.mperez.csb.math.Point;

public class Car {

    private final Point point;
    private final Point velocity;
    private final int angle;
    private final Point checkpoint;
    private final double distance;

    public Car(Point point, Point velocity, int angle, Point checkpoint, double distance) {
        this.point = point;
        this.velocity = velocity;
        //TODO : angle is probably angle of pod now, and not angle between pod and checkpoint
        this.angle = angle;
        this.checkpoint = checkpoint;
        this.distance = distance;
    }

    public Point getPoint() {
        return point;
    }

    public Point getVelocity() {
        return velocity;
    }

    public int getAngle() {
        return angle;
    }

    public Point getCheckpoint() {
        return checkpoint;
    }

    public double getDistance(){
        return distance;
    }
}
