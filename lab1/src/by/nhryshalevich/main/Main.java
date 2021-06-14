package by.nhryshalevich.main;

import by.nhryshalevich.main.Point2D.Point2D;
import by.nhryshalevich.main.Line2D.Line2D;
import by.nhryshalevich.action.Line2DAction.Line2DAction;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        Point2D aPoint = new Point2D(1, 2, 1, 2);  // A(1/2, 1/2)
        Point2D bPoint = new Point2D(-1, 2, -1, 2);  // B(-1/2, -1/2)
        Point2D cPoint = new Point2D(12, 2, 4, 2);  // C(6, 2)
        Point2D dPoint = new Point2D(0, 1, -4, 1); // D(0, 4)
        Point2D ePoint = new Point2D(2, 1, 6, 1); // E(2, 6)
        Point2D fPoint = new Point2D(4, 1, -4, 1); // F(4, -4)
        Point2D gPoint = new Point2D(-2, 1, 4, 1); // J(-2, 4)
        Point2D hPoint = new Point2D(0, 1, -6, 1); // H(0, -6)
        Point2D lPoint = new Point2D(-6, 1, 0, 11); // L(-6, 0)
        Point2D mPoint = new Point2D(8, 1, 2, 1); // M(8, 2)
        Point2D kPoint = new Point2D(-8, 1, 2, 1); // K(-8, 2)
        Point2D oPoint = new Point2D(79, 20, 49, 4); // O(3.95, 12.25)

        Line2D[] allLines = {
            new Line2D(aPoint, bPoint),  // x - y = 0
            new Line2D(cPoint, dPoint),  // x - y = 4
            new Line2D(ePoint, fPoint),  // 5x + y = 16
            new Line2D(gPoint, hPoint), // 5x + y = -6
            new Line2D(lPoint, mPoint), // -x + 7y = 6
            new Line2D(lPoint, kPoint), // -x - y = 6
            new Line2D(cPoint, oPoint)  // 10x + 2y = 64 (or 5x + y = 32)
                            };

        System.out.println("All lines: " + Arrays.toString(allLines));

        // Array of Arrays that are groups of parallel lines
        ArrayList<ArrayList<Line2D>> parallelLines = new ArrayList<ArrayList<Line2D>>();

        // This array will be used to remove line if it is parrallel
        // for another one
        ArrayList<Line2D> allNonparallelLines = new ArrayList<>(Arrays.asList(allLines));

        int i = 0, //j = 1,
            nonParallelLen = allLines.length;

        while (i < nonParallelLen) {
            int indexOfIline = Arrays.asList(allLines).indexOf(allNonparallelLines.get(i));
            for (int j = 1 + indexOfIline; j < allLines.length; j++) {
                try {
                    Line2DAction.getInterisectionWith(allNonparallelLines.get(i), allLines[j]);
                    // No error -- lines are not parallel
                    continue;
                }
                catch (ArithmeticException e) {
                    // Add group for this line if it doesn't exist
                    if (i >= parallelLines.size()) {
                        ArrayList<Line2D> newGroupOfParrallLines = new ArrayList<Line2D>();
                        newGroupOfParrallLines.add(allNonparallelLines.get(i));
                        newGroupOfParrallLines.add(allLines[j]);
                        parallelLines.add(newGroupOfParrallLines);
                    }
                    else {
                        ArrayList<Line2D> groupOfLines = parallelLines.get(i);
                        groupOfLines.add(allLines[j]);
                        parallelLines.set(i, groupOfLines);
                    }
                    allNonparallelLines.remove(allLines[j]);
                    nonParallelLen = allNonparallelLines.size();
                }
            }
            //j = 0;
            i++;
        }

        System.out.println("-------------------------------------");
        for (ArrayList<Line2D> arr: parallelLines) {
            System.out.println("Group of parallel Lines:");
            for (Line2D elem: arr) {
                System.out.print(elem.toString() + "\n");
            }
            System.out.println("===================");
        }
    }
}
