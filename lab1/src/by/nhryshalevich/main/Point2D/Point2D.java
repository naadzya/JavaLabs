package by.nhryshalevich.main.Point2D;

import by.nhryshalevich.main.Rational.Rational;

public class Point2D {
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

    public Point2D() {
        x = new Rational();
        y = new Rational();
    }

    public Point2D(Rational ratio1, Rational ratio2) {
        x = ratio1;
        y = ratio2;
    }

    public Point2D(int x_num, int x_den, int y_num, int y_den) {
        x = new Rational(x_num, x_den);
        y = new Rational(y_num, y_den);
    }

    public Rational getX() {
        return x;
    }

    public Rational getY() {
        return y;
    }

    public void setX(Rational x) {
        this.x = x;
    }

    public void setY(Rational y) {
        this.y = y;
    }

    public String toString() {
        return String.format("(%s, %s)", x.toString(), y.toString());
    }
}
