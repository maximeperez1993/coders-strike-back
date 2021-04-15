package fr.mperez.csb;

import fr.mperez.csb.game.car.Car;
import fr.mperez.csb.math.Physics;
import fr.mperez.csb.math.Point;

public class Engine {

    private static boolean hasBoost = true;

    public void update(Car car) {
        System.err.println("car=" + car);

        // Fix boost, set one boost by car
        if (hasBoost && car.getDistance() > 5000 && car.getAngle() == 0) {
            boost(car);
            return;
        }
        Point target = manageTarget(car);
        int speed = manageSpeed(car);
        System.out.println(target.getX() + " " + target.getY() + " " + speed);
    }

    private Point manageTarget(Car car) {
        Point checkpoint = car.getCheckpoint();
        Point velocity = car.getVelocity();
        int x = checkpoint.getX() - (velocity.getX() * 3);
        int y = checkpoint.getY() - (velocity.getY() * 3);
        return new Point(x, y);
    }

    private int manageSpeed(Car car) {
        double factor = Math.cos(Math.toRadians(car.getAngle())) * 0.15;
        double force = factor * car.getDistance();
        return (int) Physics.clamp(force,0, 100);
    }

    private void boost(Car car) {
        Point target = car.getCheckpoint();
        System.out.println(target.getX() + " " + target.getY() + " BOOST");
        hasBoost = false;
    }

}
