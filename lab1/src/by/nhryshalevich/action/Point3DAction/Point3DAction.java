package by.nhryshalevich.action.Point3DAction;

import by.nhryshalevich.main.Rational.Rational;
import by.nhryshalevich.main.Point3D.Point3D;
import by.nhryshalevich.action.RationalAction.RationalAction;

public class Point3DAction {

    public static double getDistance(Point3D point1, Point3D point2) {
        Rational ratio1 = RationalAction.subtract(point2.getX(),
                                                  point1.getX()).square();
        Rational ratio2 = RationalAction.subtract(point2.getY(),
                                                  point1.getY()).square();
        Rational ratio3 = RationalAction.subtract(point2.getZ(),
                                                  point1.getZ()).square();

        Rational firstSum = RationalAction.add(ratio1, ratio2);
        return Math.sqrt(RationalAction.add(firstSum, ratio3).rationalToFloat());
    }

    public static double getDistanceFromOrigin(Point3D point) {
        return getDistance(point, new Point3D());
    }
}
