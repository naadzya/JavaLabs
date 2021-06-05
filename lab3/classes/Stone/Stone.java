package classes.Stone;

public abstract class Stone {
    private double mass; // in carats
    private double cost; // in dollars
    private int value;
    private int transparency;

    public Stone(double mass, double cost, int value, int transparency) {
        if (mass <= 0 || cost <= 0 || 
            value <= 0 || value > 10 || 
            transparency < 0 || transparency > 100) {
                throw new IllegalArgumentException();
        }
        this.mass = mass;
        this.cost = cost;
        this.value = value;
        this.transparency = transparency;
    }
}
