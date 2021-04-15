package fr.mperez.csb.math;

public class Physics {

    public Point calculateVelocity(Point previous, Point current){
        return new Point(current.getX() - previous.getX(),current.getY() - previous.getY());
    }
}
