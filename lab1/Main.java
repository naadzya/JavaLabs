//import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Rational x = new Rational(1, 2);
        //Rational y = new Rational(-36, 4);
        //Rational z = new Rational(1, 4);
        
        Point2D p1 = new Point2D(1, 1, 1, 1);
        Point2D p2 = new Point2D(-1, 1, -1, 1);
        Point2D p3 = new Point2D(0, 1, 2, 1);
        Point2D p4 = new Point2D(10, 5, 0, 5);

        Line2D line1 = new Line2D(p1, p2);
        Line2D line2 = new Line2D(p3, p4);

        System.out.println(line1.getInterisectionWith(line2).toString());
    }
}
