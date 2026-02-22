package designpatterns.creational.builder.pizzabuilder;

public class PizzaDirector {

    public Pizza buildMargherita(PizzaSize size){
        return new Pizza.Builder(size)
                .cheese("mozzarella").sauce("tomato").crust("regular")
                .addTopping("basil").build();
    }

    public Pizza buildVeggie(PizzaSize size){
        return new Pizza.Builder(size)
                .crust("whole wheat").sauce("pesto").cheese("gouda")
                .addTopping("mushrooms").addTopping("peppers")
                .addTopping("onions").addTopping("olives").build();
    }


    public Pizza buildPepperoni(PizzaSize size){
        return new Pizza.Builder(size)
                .crust("thin").sauce("tomato").cheese("mozzarella")
                .addTopping("pepperoni").addTopping("olives").build();
    }

}
