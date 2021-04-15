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

    public static int angle(Point src, Point dst, int srcAngle) {
        int tempAngle = (int) (Math.toDegrees(vectorAngle(new int[]{1, 0}, directionVector(src, dst))));
        tempAngle = Math.abs(srcAngle - tempAngle);
        return 180-tempAngle;
    }

    private static double vectorAngle(int[] v1, int[] v2) {
        return Math.atan2(v2[1], v2[0]) - Math.atan2(v1[1], v1[0]);
    }

    private static int[] directionVector(Point p1, Point p2) {
        return (new int[]{p1.getX() - p2.getX(), p1.getY() - p2.getY()});
    }
}
