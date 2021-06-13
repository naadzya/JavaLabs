package by.nhryshalevich.main.Line2D;

import by.nhryshalevich.main.Rational.Rational;
import by.nhryshalevich.main.Point2D.Point2D;
import by.nhryshalevich.action.RationalAction.RationalAction;
import by.nhryshalevich.action.Point2DAction.Point2DAction;

public class Line2D{
/*
 * A class that represents a line on a plane with rational coordinates
 *
 * Attributes
 * ------
 *  p1: Point2D
 *    an object that represents starting point on the line
 *  p2: Point2D
 *    the end of the vector from the starting point
 *
 * Methods
 * -------
 */
    private Point2D p1;
    private Point2D p2;

    public Line2D() {
        p1 = new Point2D();
        p2 = new Point2D();
    }

    public Line2D(Point2D p1, Point2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line2D(Rational p1X, Rational p1Y, Rational p2X, Rational p2Y) {
        p1 = new Point2D(p1X, p1Y);
        p2 = new Point2D(p2X, p2Y);
    }

    public Line2D(int p1_xnum, int p1_xden, int p1_ynum, int p1_yden,
                  int p2_xnum, int p2_xden, int p2_ynum, int p2_yden) {
        p1 = new Point2D(p1_xnum, p1_xden, p1_ynum, p1_yden);
        p2 = new Point2D(p2_xnum, p2_xden, p2_ynum, p2_yden);
    }

    public Point2D getP1() {
        return p1;
    }

    public void setP1(Point2D p1) {
        this.p1 = p1;
    }

    public Point2D getP2() {
        return p2;
    }

    public void setP2(Point2D p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        Rational a = RationalAction.subtract(p1.getY(),
                                             p2.getY());
        Rational b = RationalAction.subtract(p2.getX(),
                                             p1.getX());
        Rational c =  RationalAction.subtract(
                       RationalAction.mult(p1.getX(), p2.getY()),
                       RationalAction.mult(p2.getX(), p1.getY()));

        return a + "*x " + " + " + b + "*y + " + c + " = 0";
    }
}
