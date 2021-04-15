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
        if (state.myCar().angle() > 90 || state.myCar().angle() < -90) {
            return 0;
        }

        if (geometry.isBetween(state.myCar().distance(), 1000,2000)) {
            return 90;
        }

        if (geometry.isBetween(state.myCar().distance(), 2000,3000)) {
            return 95;
        }



        return 100;
    }

    private void boost() {
        System.out.println(state.nextCheckpoint().getX() + " " + state.nextCheckpoint().getY() + " BOOST");
        hasBoost = false;
    }

}
