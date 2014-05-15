package de.uniluebeck.itm.mathutils;

/**
 * A geometric line
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
     */
    public Line(Point pointA, Point pointB){
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

    public static Point getIntersection(Line line1, Line line2){

        if(line1.getM() == line2.getM())
            throw new IllegalArgumentException("Given lines are parallel!");

        else if(line1.getM() != 0 && line2.getM() != 0 &&
               (line1.getM() % line2.getM() == 0 || line2.getM() % line1.getM() == 0))
            throw new IllegalArgumentException("Given lines are parallel!");

        double x = (line2.getB() - line1.getB()) / (line1.getM() - line2.getM());
        double y = line1.getY(x);

        return new Point(x, y);
    }


    public String toString(){
        return "y = " + m + "x + " + b;
    }
}
