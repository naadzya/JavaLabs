package by.nhryshalevich.main.Point3D;

import by.nhryshalevich.main.Rational.Rational;
import by.nhryshalevich.action.RationalAction.RationalAction;

public class Point3D {
/*
 * A class that represents mathematical rational number as ratio
 *
 * Attributes
 * ------
 *  x: Rational
 *      the x-coordinate
 *  y: Rational
 *      the y-coordinate
 *  z: Rational
 *      the z-coordinate
 *
 * Methods
 * -------
 *
 */
    private Rational x;
    private Rational y;
    private Rational z;

    public Point3D() {
        x = new Rational();
        y = new Rational();
        z = new Rational();
    }

    public Point3D(Rational ratio1, Rational ratio2, Rational ratio3) {
        x = ratio1;
        y = ratio2;
        z = ratio3;
    }

    public Point3D(int x_num, int x_den, int y_num, int y_den, int z_num, int z_den) {
        x = new Rational(x_num, x_den);
        y = new Rational(y_num, y_den);
        z = new Rational(z_num, z_den);
    }

    public Rational getX() {
        return x;
    }

    public void setX(Rational x) {
        this.x = x;
    }

    public Rational getY() {
        return y;
    }

    public void setY(Rational y) {
        this.y = y;
    }

    public Rational getZ() {
        return z;
    }

    public void setZ(Rational z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", x.toString(), y.toString(), z.toString());
    }

}
