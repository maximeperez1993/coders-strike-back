package fr.mperez.csb;

import fr.mperez.csb.game.car.Car;
import fr.mperez.csb.math.Geometry;
import fr.mperez.csb.math.Physics;
import fr.mperez.csb.math.Point;

public class Engine {
    private final TurnState state;
    private final TurnState previousState;
    private final Physics physics;

    private static boolean hasBoost = true;

    public Engine(TurnState state, TurnState previousState, Physics physics) {
        this.state = state;
        this.previousState = previousState;
        this.physics = physics;
    }

    public void update(Car car) {
        System.err.println("dist=" + car.getDistance() + "  angle=" + car.getAngle());

        if (hasBoost && car.getDistance() > 5000 && car.getAngle() == 0) {
            boost(car);
            return;
        }
        Point target = manageTarget(car);
        int speed = manageSpeed(car);
        System.out.println(target.getX() + " " + target.getY() + " " + speed);
    }

    private Point manageTarget(Car car) {
        Point myCarVelocity = car.getVelocity();
        System.err.println("velocity=" + myCarVelocity);
        int x = car.getCheckpoint().getX() - (myCarVelocity.getX() * 3);
        int y = car.getCheckpoint().getY() - (myCarVelocity.getY() * 3);
        return new Point(x, y);
    }

    private int manageSpeed(Car car) {
        if (car.getAngle() >= 90 || car.getAngle() <= -90) {
            return 0;
        }

        double factor = Math.cos(Math.toRadians(car.getAngle())) * 0.15;
        double force = (factor * car.getDistance());
        System.err.println("factor=" + factor + "  distance=" + car.getDistance() + " force=" + force);
        force = Math.min(force, 100);
        force = Math.max(0, force);
        return (int) force;
    }

    private void boost(Car car) {
        System.out.println(car.getCheckpoint().getY() + " BOOST");
        hasBoost = false;
    }

}
