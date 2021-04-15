package fr.mperez.csb;

import fr.mperez.csb.math.Geometry;

public class Engine {
    private final GameState state;
    private final GameState previousState;
    private final Geometry geometry;

    private static boolean hasBoost = true;

    public Engine(GameState state,GameState previousState, Geometry geometry) {
        this.state = state;
        this.previousState = previousState;
        this.geometry = geometry;
    }

    public void update() {
        System.err.println("dist=" + state.myCar().distance() + "  angle=" + state.myCar().angle());

        if (hasBoost && state.myCar().distance() > 5000 && state.myCar().angle() == 0) {
            boost();
            return;
        }
        System.out.println(state.nextCheckpoint().getX() + " " + state.nextCheckpoint().getY() + " " + manageSpeed());

    }

    private int manageSpeed() {
        if (state.myCar().angle() >= 90 || state.myCar().angle() <= -90) {
            return 0;
        }

        double factor = Math.cos(Math.toRadians(state.myCar().angle())) * 0.15;
        double force = (factor * state.myCar().distance());
        System.err.println("factor=" + factor + "  distance=" + state.myCar().distance() + " force="+force);
        force = Math.min(force, 100);
        force = Math.max(0, force);
        return (int)force;
    }

    private void boost() {
        System.out.println(state.nextCheckpoint().getX() + " " + state.nextCheckpoint().getY() + " BOOST");
        hasBoost = false;
    }

}
