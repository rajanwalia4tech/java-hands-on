package designpatterns.creational.builder.pizzabuilder;

import java.util.*;

public class Pizza {
    private final PizzaSize size;
    private final String crust;
    private final String sauce;
    private final String cheese;
    private final List<String> toppings;

    Pizza(Builder builder){
        this.size = builder.size;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", crust='" + crust + '\'' +
                ", sauce='" + sauce + '\'' +
                ", cheese='" + cheese + '\'' +
                ", toppings=" + toppings +
                '}';
    }

    public static class Builder{
        private final PizzaSize size;
        private String crust = "regular";
        private String sauce = "tomato";
        private String cheese = "mozzarella";
        private List<String> toppings = new ArrayList<>();

        Builder(PizzaSize size){
            this.size = size;
        }

        public Builder crust(String crust){
            this.crust = crust;
            return this;
        }

        public Builder sauce(String sauce){
            this.sauce = sauce;
            return this;
        }

        public Builder cheese(String cheese){
            this.cheese = cheese;
            return this;
        }

        public Builder addTopping(String topping){
            this.toppings.add(topping);
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }

    }

}
