//import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        GuitarString em = new GuitarString("Em", "iron", 10, "SomeVendor1");
        GuitarString am = new GuitarString("Am", "copper", 20, "SomeVendor2");
        em.replace(am);
        System.out.println(em.equals(am));
        System.out.println(em.hashCode() == am.hashCode());
    }
}
