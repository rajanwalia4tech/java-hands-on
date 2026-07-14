package lld.snakeandladders.entities;

public class Dice {
    private int minValue;
    private int maxValue;

    public Dice(int minValue, int maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int roll(){
        // math.random function to generate the number from minValue to Max Value
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }
}
