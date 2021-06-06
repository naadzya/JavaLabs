package src.Gemstone;

import src.Stone.Stone;

public class Gemstone extends Stone {
    private GemstonesNames name;

    public Gemstone(String name, double mass, double cost,
                         int value, int transparency) {
        super(mass, cost, value, transparency);
        this.name = GemstonesNames.valueOf(name);
    }

    public String toString() {
        return name.toString();
    }
}
