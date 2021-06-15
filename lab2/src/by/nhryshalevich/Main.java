package by.nhryshalevich;

//import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Guitar bassGuitar = new Guitar(new GuitarString[]{
                                  new GuitarString("A", "iron", 10, "SomeVendor1"),
                                  new GuitarString("Eb", "iron", 10, "SomeVendor1"),
                                  new GuitarString("Bb", "iron", 10, "SomeVendor1"),
                                  new GuitarString("F", "iron", 10, "SomeVendor1"),
                                  },
                                  new Birdhouse("oak", 10, 10, 25));
        System.out.println("Bass guitar:\n" + bassGuitar.toString()
                           + "\nPlay 3, 2, 1, 4 strings: " );
        bassGuitar.play(new int[] {3, 2, 1, 4});
        bassGuitar.tuning(1, "G#");
        System.out.println("Tune 1st string to sound as G# note.\nPlay 1, 4, 2 strings");
        bassGuitar.play(new int[] {1, 4, 2});
        bassGuitar.replaceString(1, new GuitarString("A", "iron", 10, "SomeVendor1"));
               System.out.println("Replace 1st string with "
                                  + bassGuitar.getStrings()[0].toString());
        bassGuitar.play(new int[] {1, 4, 2});
        System.out.println(bassGuitar.toString());

        System.out.println("Acoustic guitar:");
        Guitar acousticGuitar = new Guitar(new GuitarString[]{
                                  new GuitarString("E", "iron", 10, "Vendor2"),
                                  new GuitarString("B", "iron", 10, "Vendor2"),
                                  new GuitarString("G", "iron", 10, "Vendor2"),
                                  new GuitarString("D", "iron", 10, "Vendor2"),
                                  new GuitarString("A", "iron", 10, "Vendor2"),
                                  new GuitarString("E", "iron", 10, "Vendor2"),
                                  },
                                  new Birdhouse("oak", 10, 10, 25));
        System.out.println(acousticGuitar.toString());

        System.out.println("Are bass guitar and acoustic guitar equal? "
                           + bassGuitar.equals(acousticGuitar));
        System.out.println("Are hashcodes of bass guitar and acoustic guitar equals? "
                           + (bassGuitar.hashCode() == acousticGuitar.hashCode()));

    }
}
