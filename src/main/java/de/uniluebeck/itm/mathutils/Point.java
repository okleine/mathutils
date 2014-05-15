package de.uniluebeck.itm.mathutils;

/**
 * A point in a coordinate system
 *
 * @author Oliver Kleine
 */
public class Point {

    private double x;
    private double y;

    /**
     * Creates a new {@link Point} based on the given coordinates
     * @param x the coordinate x
     * @param y the coordinate y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the coordinate y of this {@link Point}
     * @return the coordinate y of this {@link Point}
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the coordinate x of this {@link Point}
     * @return the coordinate x of this {@link Point}
     */
    public double getX() {
        return x;
    }

    @Override
    public String toString(){
        return "Point(x=" + getX() + ", y=" + getY() + ")";
    }
}
