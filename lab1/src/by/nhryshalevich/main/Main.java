package by.nhryshalevich.main;

import by.nhryshalevich.main.Point2D.Point2D;
import by.nhryshalevich.main.Line2D.Line2D;
import by.nhryshalevich.action.Line2DAction.Line2DAction;

//import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Point2D p1 = new Point2D(1, 2, 1, 2);  // (1/2, 1/2)
        Point2D p2 = new Point2D(-1, 2, -1, 2);  //(-1/2, -1/2)
        Point2D p3 = new Point2D(0, 1, 2, 1);  //(0, 2)
        Point2D p4 = new Point2D(10, 5, 0, 5); // (2, 0)

        Line2D line1 = new Line2D(p1, p2);  // y = x
        Line2D line2 = new Line2D(p3, p4);  // y = 2 - x

        System.out.println(line1.toString() + "\n" + line2.toString());
        System.out.println(Line2DAction.getInterisectionWith(line1, line2).toString());
    }
}
