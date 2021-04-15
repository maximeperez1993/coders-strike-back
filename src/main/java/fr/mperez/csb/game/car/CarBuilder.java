package fr.mperez.csb.game.car;

import fr.mperez.csb.math.Geometry;
import fr.mperez.csb.math.Physics;
import fr.mperez.csb.math.Point;

public class CarBuilder {
    private Point point;
    private Point velocity;
    private int angle;
    private Point checkpoint;

    public CarBuilder setPoint(Point point) {
        this.point = point;
        return this;
    }

    public CarBuilder setVelocity(Point velocity) {
        this.velocity = velocity;
        return this;
    }

    public CarBuilder setAngle(int angle) {
        this.angle = angle;
        return this;
    }

    public CarBuilder setCheckpoint(Point checkpoint){
        this.checkpoint = checkpoint;
        return this;
    }

    public Car build() {
        return new Car(point, velocity, angle, checkpoint);
    }
}
