package fr.mperez.csb;

import fr.mperez.csb.math.Geometry;
import fr.mperez.csb.math.Physics;
import fr.mperez.csb.math.Point;

public class Engine {
    private final TurnState state;
    private final TurnState previousState;
    private final Geometry geometry;
    private final Physics physics;

    private static boolean hasBoost = true;

    public Engine(TurnState state, TurnState previousState, Geometry geometry, Physics physics) {
        this.state = state;
        this.previousState = previousState;
        this.geometry = geometry;
        this.physics = physics;
    }

    public void update() {
        System.err.println("dist=" + state.myCar().distance() + "  angle=" + state.myCar().angle());

        if (hasBoost && state.myCar().distance() > 5000 && state.myCar().angle() == 0) {
            boost();
            return;
        }
        Point target = manageTarget();
        System.out.println(target.getX() + " " + target.getY() + " " + manageSpeed());
    }

    private Point manageTarget() {
        Point myPreviousCarPoint = previousState != null ? previousState.myCar().getPoint() : new Point(0, 0);
        Point myCarVelocity = physics.calculateVelocity(myPreviousCarPoint, state.myCar().getPoint());
        System.err.println("velocity=" + myCarVelocity);
        int x = state.nextCheckpoint().getX() - (myCarVelocity.getX() * 3);
        int y = state.nextCheckpoint().getY() - (myCarVelocity.getY() * 3);
        return new Point(x, y);
    }

    private int manageSpeed() {
        if (state.myCar().angle() >= 90 || state.myCar().angle() <= -90) {
            return 0;
        }

        double factor = Math.cos(Math.toRadians(state.myCar().angle())) * 0.15;
        double force = (factor * state.myCar().distance());
        System.err.println("factor=" + factor + "  distance=" + state.myCar().distance() + " force=" + force);
        force = Math.min(force, 100);
        force = Math.max(0, force);
        return (int) force;
    }

    private void boost() {
        System.out.println(state.nextCheckpoint().getX() + " " + state.nextCheckpoint().getY() + " BOOST");
        hasBoost = false;
    }

}
