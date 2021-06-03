public class Guitar {
/*
 * a class that represents guitar with strings
 * which is made from a birdhouse
 *
 * Attributes:
 * ----------
 *
 *
 * Methods:
 * -------
 */
  
    private GuitarString[] strings;
    private Birdhouse corpus;
  
    public Guitar(GuitarString[] strings, Birdhouse corpus) {
        this.strings = strings;
        this.corpus = corpus;
    }
  
    public void play(int[] stringsOrder) {
        for (int i: stringsOrder) {
            if (i < 1 || i > strings.length) {
                throw new ArrayIndexOutOfBoundsException(String.valueOf(i) + 
                                          " is incorrect number of Guitar's string");
            }
            strings[i-1].play();
            System.out.print(" ");
        }
        System.out.println();
    }
  
    public void tuning(int stringNumber, String note) {
        // Keep in mind that guitar strings are numerated 
        // starting from 0 (as in reality)
        if (stringNumber < 1 || stringNumber > strings.length) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(stringNumber) + 
                                  "Incorrect number of Guitar's string");
        }
        strings[stringNumber-1].setNote(note);
    }
  
    public void replaceString(int stringNumber, GuitarString newString) {
        if (stringNumber < 1 || stringNumber > strings.length) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(stringNumber) + 
                                  "Incorrect number of Guitar's string");
        }
        strings[stringNumber-1].replace(newString);
    }
 
    public String toString() {
        int stringsTotal = strings.length;
        String notes = "";
        for (int i = strings.length-1; i >= 0; i--) {
            notes += strings[i].getNote() + " ";
        }
        String result = "       _" + "_".repeat(stringsTotal-2) + "_" + "\n" +
                        "     o|*" + " ".repeat(stringsTotal-2) + "*|o\n" +
                        "     o|*" + " ".repeat(stringsTotal-2) + "*|o\n" +
                        "     o|*" + " ".repeat(stringsTotal-2) + "*|o\n" +
                        "      \\" + "=".repeat(stringsTotal) + "/\n" +
                        "       " + "|".repeat(stringsTotal) + "\n" +
                        "       " + "|".repeat(stringsTotal) + "\n" +
                        "     " + notes + "\n" +
                        "       " + "|".repeat(stringsTotal) + "\n" +
                        "       " + "|".repeat(stringsTotal) + "\n" +
                        "    ___" + "|".repeat(stringsTotal) + "___\n" +
                        "   /   " + "|".repeat(stringsTotal) + "   \\\n" +
                        "  /    " + "|".repeat(stringsTotal) + "    \\\n" +
                        " /     " + "|".repeat(stringsTotal) + "     \\\n" +
                        " |     " + "|".repeat(stringsTotal) + "     |\n" +
                        "  \\   (" + "|".repeat(stringsTotal) + ")   /\n" +
                        "   |   " + "|".repeat(stringsTotal) + "   |\n" +
                        "  /    " + "|".repeat(stringsTotal) + "    \\\n" +
                        " /     " + "|".repeat(stringsTotal) + "     \\\n" +
                        "/      " + "|".repeat(stringsTotal) + "      \\\n" +
                        "|     [" + "=".repeat(stringsTotal) + "]     |\n" +
                        " \\     " + " ".repeat(stringsTotal) + "     /\n" +
                        "  '.   " + " ".repeat(stringsTotal) + "   .'\n" +
                        "    '" + "-".repeat(stringsTotal+4) + "'\n";
        return result;
    }

    public int hashCode() {
        int result = 0;
        for (GuitarString str: strings) {
            result += str.hashCode();
        }
        return result + corpus.hashCode();
    }

    public boolean equals(Guitar another) {
        boolean flag = corpus.equals(another.corpus);
        if (! flag || strings.length != another.strings.length) {
            return false;
        }
        for (int i = 0; i < strings.length; i++) {
            flag = strings[i].equals(another.strings[i]);
            if (! flag)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Guitar bassGuitar = new Guitar(new GuitarString[]{
                                  new GuitarString("A", "iron", 10, "SomeVendor1"),
                                  new GuitarString("Eb", "iron", 10, "SomeVendor1"),
                                  new GuitarString("Bb", "iron", 10, "SomeVendor1"),
                                  new GuitarString("F", "iron", 10, "SomeVendor1"),
                                  }, 
                                  new Birdhouse("oak", 10, 10, 25));
        //bassGuitar.play(new int[] {3, 2, 1, 4});
        bassGuitar.tuning(1, "F");
        //bassGuitar.play(new int[] {1, 4, 2});
        bassGuitar.replaceString(1, new GuitarString("A", "iron", 10, "SomeVendor1"));
        //bassGuitar.play(new int[] {1, 4, 2});
        System.out.println(bassGuitar.toString());

        Guitar acousticGuitar = new Guitar(new GuitarString[]{
                                  new GuitarString("E", "iron", 10, "Vendor2"),
                                  new GuitarString("B", "iron", 10, "Vendor2"),
                                  new GuitarString("G", "iron", 10, "Vendor2"),
                                  new GuitarString("D", "iron", 10, "Vendor2"),
                                  new GuitarString("A", "iron", 10, "Vendor2"),
                                  new GuitarString("E", "iron", 10, "Vendor2"),
                                  }, 
                                  new Birdhouse("oak", 10, 10, 25));
        //System.out.println(bassGuitar.hashCode() == acousticGuitar.hashCode());
        //System.out.println(bassGuitar.equals(acousticGuitar));
        System.out.println(acousticGuitar.toString());

    }
}
