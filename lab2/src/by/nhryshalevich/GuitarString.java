package by.nhryshalevich;

public class GuitarString {
/*
 * A class used to represent string of guitar
 *
 * Attributes:
 * ----------
 *  note: String
 *  material: String
 *  caliber: int
 *  vendor: String
 *
 * Methods:
 * -------
 */

    private String note;
    private String material;
    private int caliber; // diameter*1000
    private String vendor;

    public GuitarString(String note, String material, int caliber, String vendor) {
        this.note = note;
        this.material = material;
        this.caliber = caliber;
        this.vendor = vendor;
    }

    public String getNote() {
        return note;
    }

    public String getMaterial() {
        return material;
    }

    public int getCaliber() {
        return caliber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void replace(GuitarString newGuitString) {
        this.note = newGuitString.note;
        this.material = newGuitString.material;
        this.caliber = newGuitString.caliber;
        this.vendor = newGuitString.vendor;
    }

    public void play() {
        System.out.print(this.note);
    }
    
    public String toString() {
        return vendor + "'s string which is made of " + material + " with caliber "
               + String.valueOf(caliber) + " and represents the note " + note;
    }

    public int hashCode() {
        return note.hashCode() + material.hashCode() 
               + caliber + vendor.hashCode();
    }

    public boolean equals(GuitarString anotherString) {
        return note == anotherString.note &&
               material == anotherString.material &&
               caliber == anotherString.caliber &&
               vendor == anotherString.vendor;
    }
}
