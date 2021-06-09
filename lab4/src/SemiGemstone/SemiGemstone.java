package src.SemiGemstone;

import src.Stone.Stone;

public class SemiGemstone extends Stone {
    private SemiGemstonesNames name;
   
    public SemiGemstone(String name, double mass, double cost,
                            int value, int transparency) {
        super(mass, cost, value, transparency);
        this.name = SemiGemstonesNames.valueOf(name);
    }

    public String toString() {
        return "name: " + name.toString() + 
               ", mass: " + String.valueOf(this.getMass()) + 
               ", cost: " + String.valueOf(this.getCost()) + 
               ", value: " + String.valueOf(this.getValue()) + 
               ", transparency: " + String.valueOf(this.getTransparency());
    }

}
