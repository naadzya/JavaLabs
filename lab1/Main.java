//import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Rational x = new Rational(1, 2);
        x.setnum(5);
        System.out.println(x.toString());

        Rational y = new Rational(3, 4);

        Rational z = new Rational(0, 4);

        Point3D p = new Point3D(x, y, z);

        System.out.println(p.toString());
    }
}
