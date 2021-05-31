public class Point {
/*
 * A class that represents mathematical rational number as ratio
 *
 * Fields
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

    public Point() {
        this.x = new Rational();
        this.y = new Rational();
        this.z = new Rational();
    }

    public Point(Rational ratio1, Rational ratio2, Rational ratio3) {
        this.x = ratio1;
        this.y = ratio2;
        this.z = ratio3;
    }

    public Point(int x_num, int x_den, int y_num, int y_den, int z_num, int z_den) {
        this.x = new Rational(x_num, x_den);
        this.y = new Rational(y_num, y_den);
        this.z = new Rational(z_num, z_den);
    }

    public String toString() {
        return String.format("(x, y, z) = (%s, %s, %s)", x.toString(), y.toString(), z.toString());
    }

    public double getDistance(Point p) {
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
