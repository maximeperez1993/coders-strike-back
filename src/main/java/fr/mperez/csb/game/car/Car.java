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
    private final boolean hasBoost;
    private final Runnable onBoost;

    public Car(Point point, Point velocity, int angleAbsolute, Point checkpoint, boolean hasBoost, Runnable onBoost) {
        this.point = point;
        this.velocity = velocity;
        this.angleAbsolute = angleAbsolute;
        this.checkpoint = checkpoint;
        this.angle = Geometry.angle(point, checkpoint, angleAbsolute);
        this.distance = Geometry.distance(point, checkpoint);
        this.hasBoost = hasBoost;
        this.onBoost = onBoost;
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

    public double getDistance() {
        return distance;
    }

    public boolean hasBoost() {
        return hasBoost;
    }

    public void onBoost() {
        this.onBoost.run();
    }

    @Override
    public String toString() {
        return "Car{" +
                "hasBoost=" + hasBoost +
                ", point=" + point +
                ", angle=" + angle +
                ", velocity=" + velocity +
                ", checkpoint=" + checkpoint +
                ", angleAbsolute=" + angleAbsolute +
                ", distance=" + distance +
                "}";
    }
}
