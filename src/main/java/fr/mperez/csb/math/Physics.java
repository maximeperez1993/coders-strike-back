package fr.mperez.csb.math;

public class Physics {


    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
    }
}
