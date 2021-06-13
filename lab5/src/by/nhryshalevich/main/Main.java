package by.nhryshalevich.main;

import by.nhryshalevich.main.speech.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        String testString = "      Lorem ipsum dolor    sit amet,   consectetur adipiscing elit. Nulla vitae magna sem.\n       Suspendisse molestie non turpis ut auctor. \t Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nullam vehicula     lacinia consequat.    Donec ac leo orci!\n      Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam finibus, mi nec euismod tristique, diam tortor sagittis metus,    at vestibulum orci magna eget neque! \t\tProin eget interdum arcu, nec efficitur ex.\n            Praesent\t. tortor lacus, pharetra ac sodales eu, lobortis at velit. Mauris iaculis ante vel pharetra varius. Aliquam tincidunt risus et venenatis consequat. Curabitur interdum tellus nec justo consectetur varius?";

        System.out.println("BEFORE:\n" + testString);

        Text testPar = new Text(testString);
        testPar.breakParagraphsByLength(30);
        System.out.println("\n---------------------\n\nAFTER:\n" + testPar.toString());
        System.out.println(Arrays.toString(args));
    }
}
