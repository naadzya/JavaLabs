package by.nhryshalevich.action.Line2DAction;

import by.nhryshalevich.main.Rational.Rational;
import by.nhryshalevich.main.Point2D.Point2D;
import by.nhryshalevich.main.Line2D.Line2D;
import by.nhryshalevich.action.RationalAction.RationalAction;
import by.nhryshalevich.action.Point2DAction.Point2DAction;

public class Line2DAction {

    public static Point2D getIntersection(Line2D line1, Line2D line2)
                                                 throws ArithmeticException {
        // a line may de defined as Ax + By + C = 0
        // So here we redefine the lines using the coords of their points
        Rational a1 = RationalAction.subtract(line1.getP1().getY(),
                                              line1.getP2().getY());
        Rational b1 = RationalAction.subtract(line1.getP2().getX(),
                                              line1.getP1().getX());
        Rational c1 = RationalAction.subtract(
                       RationalAction.mult(line1.getP1().getX(), line1.getP2().getY()),
                       RationalAction.mult(line1.getP2().getX(), line1.getP1().getY()));

        Rational a2 = RationalAction.subtract(line2.getP1().getY(),
                                              line2.getP2().getY());
        Rational b2 = RationalAction.subtract(line2.getP2().getX(),
                                              line2.getP1().getX());
        Rational c2 = RationalAction.subtract(
                       RationalAction.mult(line2.getP1().getX(), line2.getP2().getY()),
                       RationalAction.mult(line2.getP2().getX(), line2.getP1().getY()));

        Rational zero = new Rational(0, 1);
        if (! a2.equals(zero) && ! b2.equals(zero) &&
            RationalAction.divide(a1, a2).equals(RationalAction.divide(b1, b2))) {
            throw new ArithmeticException("Lines are parallel or coinciding");
        }

        // By Cramer’s rule we know that the coordinates of the
        // intersection point can be fined as
        // (x0, y0) = ((b1c2-b2c1)/(a1b2-a2b1), (c1a2-c2a1)/(a1b2-a2b1))
        // so delta is the denominator of two fractions
        Rational delta = RationalAction.subtract(RationalAction.mult(a1, b2),
                                                 RationalAction.mult(a2, b1));

        Rational resultX = RationalAction.subtract(RationalAction.mult(b1, c2),
                                                   RationalAction.mult(b2, c1));
        Rational resultY = RationalAction.subtract(RationalAction.mult(c1, a2),
                                                   RationalAction.mult(c2, a1));

        return new Point2D(RationalAction.divide(resultX, delta),
                           RationalAction.divide(resultY, delta));
    }

    public static Point2D getIntersectionWithOx(Line2D line)
                                                throws ArithmeticException {
        return getIntersection(line, new Line2D(new Point2D(0, 1, 0, 1),
                                                new Point2D(1, 1, 0, 1)));
    }

    public static Point2D getIntersectionWithOy(Line2D line)
                                                throws ArithmeticException {
        return getIntersection(line, new Line2D(new Point2D(0, 1, -1, 1),
                                                new Point2D(0, 1, 1, 1)));
    }
}
