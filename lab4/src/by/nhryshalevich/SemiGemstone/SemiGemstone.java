package by.nhryshalevich.SemiGemstone;

import org.json.JSONObject;
import java.io.Serializable;
import by.nhryshalevich.Stone.Stone;

public class SemiGemstone extends Stone {
    private SemiGemstonesNames name;
    //private static final long serialVersionUID = 8369679288113450154L;

    public SemiGemstone(String name, double mass, double cost,
                            int value, int transparency) {
        super(mass, cost, value, transparency);
        this.name = SemiGemstonesNames.valueOf(name);
    }

    public SemiGemstone(JSONObject obj) {
        super(obj.getDouble("mass"),
              obj.getDouble("cost"),
              obj.getInt("value"),
              obj.getInt("transparency")
              );
        this.name = SemiGemstonesNames.valueOf(obj.getString("name"));
    }

    public String getName() {
        return name.toString();
    }

    public String toString() {
        return "name: " + name.toString() + 
               ", mass: " + String.valueOf(this.getMass()) + 
               ", cost: " + String.valueOf(this.getCost()) + 
               ", value: " + String.valueOf(this.getValue()) + 
               ", transparency: " + String.valueOf(this.getTransparency());
    }
}
