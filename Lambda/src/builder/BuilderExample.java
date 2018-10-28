package builder;

import builder.enums.BreadType;
import builder.enums.Souce;
import builder.enums.Topping;

/**
 * Clase main que nos ayudará a ver el funcionamiento de un builder.
 */
public class BuilderExample
{
	
	/**
	 * Método main.
	 * @param args Arreglo de cadenas.
	 */
	public static void main(String args[])
	{
		testPizzaBuilder();
	}
	
	/**
	 * Método donde se aprecia claramente la utilidad de un builder.
	 */
	private static void testPizzaBuilder()
	{
		PizzaBuilder pizzaBuilder = new PizzaBuilder();
		
		pizzaBuilder.withBread(BreadType.FLAT_BREAD).withSouce(Souce.TOMATO).withTopping(Topping.HAM)
				.withTopping(Topping.MOZZARELLA_CHEESE).withTopping(Topping.ONIONS);

		Pizza pizzaWithoutPepperoni = pizzaBuilder.buildPizza();

		System.out.println("-------- Pizza sin Pepperoni ------");
		showBuildedPizza(pizzaWithoutPepperoni);

		System.out.println("-------- Pizza con Pepperoni ------");
		Pizza pizzaWithPepperoni = pizzaBuilder.withTopping(Topping.PEPPERONI).withTopping(Topping.HAM).buildPizza();
		showBuildedPizza(pizzaWithPepperoni);

		System.out.println("-------- Pizza sin Pepperoni... Otra vez ------");
		Pizza pizzaWithoutPepperoniAgain = pizzaBuilder.removeAllToppings(Topping.PEPPERONI).buildPizza();
		showBuildedPizza(pizzaWithoutPepperoniAgain);
	}

	/**
	 * Método que imprime las propiedades de una pizza contruida con su builder.
	 * @param pizza Pizza que ha sido contruida con su builder.
	 */
	private static void showBuildedPizza(Pizza pizza)
	{
		System.out.println(pizza.getBreadType());
		System.out.println(pizza.getSouce());

		for (Topping topping : pizza.getToppings()) {
			System.out.println("Topping [" + topping + "]");
		}
	}
}
