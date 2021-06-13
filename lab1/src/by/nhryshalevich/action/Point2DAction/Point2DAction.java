package by.nhryshalevich.action.Point2DAction;

import by.nhryshalevich.main.Rational.Rational;
import by.nhryshalevich.main.Point2D.Point2D;
import by.nhryshalevich.action.RationalAction.RationalAction;

public class Point2DAction {

    public static double getDistance(Point2D point1, Point2D point2) {
        Rational ratio1 = RationalAction.subtract(point2.getX(),
                                                  point1.getX()).square();
        Rational ratio2 = RationalAction.subtract(point2.getY(),
                                                  point1.getY()).square();

        return Math.sqrt(RationalAction.add(ratio1, ratio2).rationalToFloat());
    }

    public static double getDistanceFromOrigin(Point2D point) {
        return getDistance(point, new Point2D());
    }
}
