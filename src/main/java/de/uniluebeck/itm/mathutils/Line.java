package de.uniluebeck.itm.mathutils;

/**
 * A geometric line in carthesian coordinate system
 *
 * @author Oliver Kleine
 */
public class Line {

    private double m;
    private double b;


    /**
     * Creates a new {@link Line} based on the given {@link Point}s
     * @param pointA the first {@link Point}
     * @param pointB the second {@link Point}
     *
     * @throws java.lang.IllegalArgumentException if both given points have the same x-coordinates
     */
    public Line(Point pointA, Point pointB) throws IllegalArgumentException{

        if(pointA.getX() == pointB.getX())
            throw new IllegalArgumentException("X-Coordinates of given points MUST be different!");

        double det1 = Determinant.getDeterminant(pointA.getX(), 1, pointB.getX(), 1);
        double detA = Determinant.getDeterminant(pointA.getY(), 1, pointB.getY(), 1);
        double detB = Determinant.getDeterminant(pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY());

        this.m = detA/det1;
        this.b = detB/det1;
    }

    /**
     * Creates a new {@link Line} instance according to y = mx + b
     * @param m the factor m
     * @param b the summand b
     */
    public Line(double m, double b){
        this.m = m;
        this.b = b;
    }


    /**
     * Returns m according to the linear equation representing this {@link Line} (y = mx + b)
     * @return m according to the linear equation representing this {@link Line} (y = mx + b)
     */
    public double getM() {
        return m;
    }


    /**
     * Returns b according to the linear equation representing this {@link Line} (y = mx + b)
     * @return b according to the linear equation representing this {@link Line} (y = mx + b)
     */
    public double getB() {
        return b;
    }

    /**
     * Returns the y-Coordinate for a given x (according to y = mx + b)
     * @param x the x-Coordinate
     * @return the y-Coordinate for a given x (according to y = mx + b)
     */
    public double getY(double x){
        return this.m * x + this.b;
    }

    /**
     * Returns <code>true</code> if this line is parallel to the given line and <code>false</code> otherwise
     *
     * @param otherLine the other {@link Line}
     *
     * @return <code>true</code> if this line is parallel to the given line and <code>false</code> otherwise
     */
    public boolean isParallelTo(Line otherLine){
        return this.getM() == otherLine.getM();
    }


    /**
     * Returns the {@link Point} representing the interception of the given lines or <code>null</code> if there is
     * no interception (lines are parallel or equal)
     *
     * @param line1 the first {@link Line}
     * @param line2 the second {@link Line}
     *
     * @return the {@link Point} representing the interception of the given lines or <code>null</code> if there is
     * no interception (lines are parallel or equal)
     */
    public static Point getIntersection(Line line1, Line line2){

        if(line1.isParallelTo(line2))
            return null;

        double x = (line2.getB() - line1.getB()) / (line1.getM() - line2.getM());
        double y = line1.getY(x);

        return new Point(x, y);
    }

    @Override
    public String toString(){
        return "y = " + m + "x + " + b;
    }
}
