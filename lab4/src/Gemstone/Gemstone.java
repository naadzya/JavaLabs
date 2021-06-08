package src.Gemstone;

import java.io.Serializable;

import src.Stone.Stone;

public class Gemstone extends Stone implements Serializable {
    private GemstonesNames name;

    public Gemstone(String name, double mass, double cost,
                         int value, int transparency) {
        super(mass, cost, value, transparency);
        this.name = GemstonesNames.valueOf(name);
    }

    public String toString() {
        return name.toString() + " -- mass: " + String.valueOf(this.getMass()) + 
               ", cost: " + String.valueOf(this.getCost()) + 
               ", value: " + String.valueOf(this.getValue()) + 
               ", transparency: " + String.valueOf(this.getTransparency());
    }
}
