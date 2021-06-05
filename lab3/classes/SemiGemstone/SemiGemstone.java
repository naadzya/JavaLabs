package classes.SemiGemstone;

import classes.Stone.Stone;

public class SemiGemstone extends Stone{
    private SemiGemstonesNames name;
   
    public SemiGemstone(String name, double mass, double cost,
                            int value, int transparency) {
        super(mass, cost, value, transparency);
        this.name = SemiGemstonesNames.valueOf(name);
    }
}
