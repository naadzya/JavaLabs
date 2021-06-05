package classes.Gemstone;

import classes.Stone.Stone;

public class Gemstone extends Stone {
    private GemstonesNames name;

    public Gemstone(String name, double mass, double cost,
                         int value, int transparency) {
        super(mass, cost, value, transparency);
        this.name = GemstonesNames.valueOf(name);
    }
}
