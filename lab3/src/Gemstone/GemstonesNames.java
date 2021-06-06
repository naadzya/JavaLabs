package src.Gemstone;

public enum GemstonesNames {
    Diamond("Diamond"),
    Ruby("Ruby"),
    BlueSapphire("BlueSapphire"),
    Emerald("Emerald");

    String name;

    GemstonesNames(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
