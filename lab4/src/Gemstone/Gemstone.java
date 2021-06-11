package src.Gemstone;

import java.io.Serializable;

import org.json.JSONObject;

import src.Stone.Stone;

public class Gemstone extends Stone {
    private GemstonesNames name;

    public Gemstone(String name, double mass, double cost,
                         int value, int transparency) {
        super(mass, cost, value, transparency);
        this.name = GemstonesNames.valueOf(name);
    }

    public Gemstone(JSONObject obj) {
        super(obj.getDouble("mass"),
              obj.getDouble("cost"),
              obj.getInt("value"),
              obj.getInt("transparency")
              );
        this.name = GemstonesNames.valueOf(obj.getString("name"));
    }
    
    public String toString() {
        return "name: "+ name.toString() +
               ", mass: " + String.valueOf(this.getMass()) + 
               ", cost: " + String.valueOf(this.getCost()) + 
               ", value: " + String.valueOf(this.getValue()) + 
               ", transparency: " + String.valueOf(this.getTransparency());
    }
}
