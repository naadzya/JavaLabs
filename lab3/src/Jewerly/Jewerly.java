package src.Jewerly;

import src.Stone.Stone;
import src.Gemstone.Gemstone;
import src.SemiGemstone.SemiGemstone;
import java.util.Arrays;

public class Jewerly {
    private Stone[] stones;
    private String brand;

    public Jewerly(Stone[] stones, String brand) {
        this.stones = stones;
        this.brand = brand;
    }

    public double countCost() {
        double total = 0;
        for (Stone stone: stones) {
            total += stone.getCost();
        }
        return total;
    }
    
    public void sortStonesByValue()
    {
        int n = stones.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (stones[j].getValue() > stones[j+1].getValue()) {
                    // swap stones[j+1] and stones[j]
                    Stone temp = stones[j];
                    stones[j] = stones[j+1];
                    stones[j+1] = temp;
                }
            }
        }
    }

    public Stone[] getStones() {
        return stones;
    }

    public Stone[] getTransparentStones(int start, int end) {
        if (start > end || start < 0 || end > 100) {
            throw new IllegalArgumentException("Incorrect transparency range");
        }
        Stone[] result = {};
        for (Stone stone: stones) {
            if (stone.getTransparency() >= start && stone.getTransparency() <= end) {
                Stone[] temp = new Stone[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    temp[i] = result[i];
                }
                temp[result.length] = stone;
                result = temp;
            }
        }
        return result;
    }
}





