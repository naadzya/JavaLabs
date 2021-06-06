package src;

import src.Stone.Stone;
import src.Gemstone.Gemstone;
import src.SemiGemstone.SemiGemstone;
import src.Jewerly.Jewerly;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Gemstone ruby = new Gemstone("Ruby", 1.1, 2.5, 8, 50);
        SemiGemstone agate = new SemiGemstone("Agate", 1.1, 2.8, 5, 10);
        Gemstone diamond = new Gemstone("Diamond", 1.1, 2.8, 10, 90);
        Gemstone diamond2 = new Gemstone("Diamond", 1.1, 2.8, 10, 70);
        Jewerly testjw = new Jewerly(new Stone[] {ruby, agate, diamond, diamond2}, "Channel");
        //testjw.sortStonesByValue();
        //System.out.println(Arrays.toString(testjw.getStones()));
        System.out.println(Arrays.toString(testjw.getTransparentStones(40, 100)));
    }
}
