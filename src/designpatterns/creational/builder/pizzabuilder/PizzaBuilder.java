package designpatterns.creational.builder.pizzabuilder;

public class PizzaBuilder {

    public static void main(String[] args) {
        Pizza customPizza = new Pizza.Builder(PizzaSize.MEDIUM)
                .cheese("shredded")
                .crust("thin")
                .addTopping("black olives")
                .addTopping("Cottage cheese")
                .sauce("Creamy White")
                .build();

        System.out.println(customPizza);

        Pizza margherita = new PizzaDirector().buildMargherita(PizzaSize.LARGE);
        Pizza pepperoni = new PizzaDirector().buildPepperoni(PizzaSize.SMALL);
        Pizza veggie = new PizzaDirector().buildVeggie(PizzaSize.MEDIUM);

        System.out.println(margherita);
        System.out.println(veggie);
        System.out.println(pepperoni);

    }
}
