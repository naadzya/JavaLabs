public class Line2D{
/*
 * A class that represents a line on a plane with rational coordinates
 *
 * Fields
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

    public Point2D getInterisectionWith(Line2D line) {
        // a line may de defined as Ax + By + C = 0
        // So here we redefine the lines using the coords of their points
        Rational a1 = p2.getY().subtract(p1.getY());
        Rational b1 = p1.getX().subtract(p2.getX());
        Rational c1 = a1.mult(p1.getX()).add(b1.mult(p1.getY()));

        Rational a2 = line.p2.getY().subtract(line.p1.getY());
        Rational b2 = line.p1.getX().subtract(line.p2.getX());
        Rational c2 = a1.mult(line.p1.getX()).add(b1.mult(line.p1.getY()));

        // By Cramer’s rule we know that the coordinates of the
        // intersection point can be fined as
        // (x0, y0) = ((b1c2-b2c1)/(a1b2-a2b1), (c1a2-c2a1)/(a1b2-a2b1))
        // so delta is the denominator of two fractions
        Rational delta = a1.mult(b2).subtract(a2.mult(b1));
    
        Rational resultX = b1.mult(c2).subtract(b2.mult(c1));
        Rational resultY = c1.mult(a2).subtract(c2.mult(a1));

        return new Point2D(resultX.divide(delta), resultY.divide(delta));
    }
}   
