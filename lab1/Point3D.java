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

    public Point3D vector(Point3D p) {
        return new Point3D(this.x.subtract(p.x), this.y.subtract(p.y), this.z.subtract(p.z));
    }

    public String toString() {
        return String.format("(%s, %s, %s)", x.toString(), y.toString(), z.toString());
    }

    public double getDistance(Point3D p) {
        Rational ratio1 = (this.x.subtract(p.x)).square();
        Rational ratio2 = (this.y.subtract(p.y)).square();
        Rational ratio3 = (this.z.subtract(p.z)).square();

        Rational firstSum = ratio1.add(ratio2);
        return Math.sqrt(firstSum.add(ratio3).rationalToFloat());
    }

    public double getDistanceFromOrigin() {
        Rational ratio1 = this.x.square();
        Rational ratio2 = this.y.square();
        Rational ratio3 = this.z.square();

        Rational firstSum = ratio1.add(ratio2);
        return Math.sqrt(firstSum.add(ratio3).rationalToFloat());
    }

}
