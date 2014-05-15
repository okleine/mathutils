package de.uniluebeck.itm.mathutils;

/**
 * Created by olli on 15.05.14.
 */
public class Main {

    public static void main(String[] args){
        Line line1 = new Line(new Point(-0.5, 0.0), new Point(1.5, 2.0));
        Line line2 = new Line(new Point(1.0, 1.0), new Point(5.0, 1.0));

        System.out.println("Line 1: " + line1);
        System.out.println("Line 2: " + line2);

        System.out.println("Interception: " + Line.getIntersection(line1, line2));
    }
}
