package src.Stone;

public abstract class Stone {
    private double mass; // in carats
    private double cost; // in dollars
    private int value;  // in range from 0 to 10
    private int transparency;  // in percentages

    public Stone(double mass, double cost, int value, int transparency) {
        if (mass <= 0 || cost <= 0 || 
            value < 0 || value > 10 || 
            transparency < 0 || transparency > 100) {
            
            throw new IllegalArgumentException();
        }
        this.mass = mass;
        this.cost = cost;
        this.value = value;
        this.transparency = transparency;
    }

    public double getMass(){
        return mass;
    }

    public double getCost(){
        return cost;
    }

    public int getValue() {
        return value;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setMass(double mass){
        if (mass <= 0) {
            throw new IllegalArgumentException();
        }
        this.mass = mass;
    }

    public void setCost(double cost){
        if (cost <= 0) {
            throw new IllegalArgumentException();
        }
        this.cost = cost;
    }

    public void setValue(int value) {
        if (value < 0 || value > 10) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public void setTransparency(int transparency) {
        if (transparency < 0 || transparency > 10) {
            throw new IllegalArgumentException();
        }
        this.transparency = transparency;
    }
}
