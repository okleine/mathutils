package de.uniluebeck.itm.mathutils;

/**
 * Helper class to compute determinants
 *
 * @author Oliver Kleine
 */
public abstract class Determinant {

    /**
     * Returns the determinant of the given matrix
     *
     * @param m11 the "upper left" element of a 2x2 matrix
     * @param m12 the "upper right" element of a 2x2 matrix
     * @param m21 the "lower left" element of a 2x2 matrix
     * @param m22 the "upper right" element of a 2x2 matrix
     *
     * @return the determinant of the given matrix
     */
    public static double getDeterminant(double m11, double m12, double m21, double m22){
        return m11 * m22 - m12 * m21;
    }

}
