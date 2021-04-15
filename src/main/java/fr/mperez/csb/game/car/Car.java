package fr.mperez.csb.game.car;

import fr.mperez.csb.math.Geometry;
import fr.mperez.csb.math.Point;

public class Car {

    private final Point point;
    private final Point velocity;
    private final int angleAbsolute;
    private final Point checkpoint;
    private final int angle;
    private final double distance;

    public Car(Point point, Point velocity, int angleAbsolute, Point checkpoint) {
        this.point = point;
        this.velocity = velocity;
        this.angleAbsolute = angleAbsolute;
        this.checkpoint = checkpoint;
        this.angle = Geometry.angle(point, checkpoint, angleAbsolute);
        this.distance = Geometry.distance(point, checkpoint);
    }

    public Point getPoint() {
        return point;
    }

    public Point getVelocity() {
        return velocity;
    }

    public int getAngleAbsolute() {
        return angleAbsolute;
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

    @Override
    public String toString() {
        return "Car{" +
                "point=" + point +
                ", angle=" + angle +
                ", velocity=" + velocity +
                ", checkpoint=" + checkpoint +
                ", angleAbsolute=" + angleAbsolute +
                ", distance=" + distance +
                "}";
    }
}
