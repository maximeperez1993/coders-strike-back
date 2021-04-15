package fr.mperez.csb.math;

public final class Geometry {

    private Geometry() {

    }

    public static double distance(Point a, Point b) {
        return Math.hypot(Math.abs(a.getX() - b.getX()), Math.abs(a.getY() - b.getY()));
    }

    /**
     * [lower;higher[
     *
     * @param property
     * @param lower
     * @param higher
     * @return
     */
    public static boolean isBetween(int property, int lower, int higher) {
        return property >= lower && property < higher;
    }


}
