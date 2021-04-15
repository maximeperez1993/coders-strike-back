package fr.mperez.csb;

import fr.mperez.csb.game.car.Car;
import fr.mperez.csb.math.Physics;
import fr.mperez.csb.math.Point;

public class CarManager {

    private final Car car;

    public CarManager(Car car) {
        this.car = car;
    }

    public void update() {
        System.err.println("car=" + car);
        System.out.println(move());
    }

    private String move(){
        if (shouldUseBoost()) {
            return moveBoost();
        }
        return moveClassic();
    }

    private String moveBoost(){
        car.onBoost();
        Point target = car.getCheckpoint();
        return target.getX() + " " + target.getY() + " BOOST";
    }

    private String moveClassic(){
        Point target = manageTarget();
        int speed = manageSpeed();
        return target.getX() + " " + target.getY() + " " + speed;
    }

    private Point manageTarget() {
        Point checkpoint = car.getCheckpoint();
        Point velocity = car.getVelocity();
        int x = checkpoint.getX() - (velocity.getX() * 3);
        int y = checkpoint.getY() - (velocity.getY() * 3);
        return new Point(x, y);
    }

    private int manageSpeed() {
        if (car.getAngle() >= 90 || car.getAngle() <= -90) {
            return 0;
        }

        double factor = Math.cos(Math.toRadians(car.getAngle())) * 0.15;
        double force = factor * car.getDistance();
        return (int) Physics.clamp(force,0, 100);
    }

    private boolean shouldUseBoost(){
        return car.hasBoost() &&
                car.getDistance() > 4000 &&
                Math.abs(car.getAngle()) <= 5;
    }

}
