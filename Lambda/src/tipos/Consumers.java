package tipos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.Empleado;
import builder.Pizza;
import builder.PizzaBuilder;
import builder.enums.BreadType;
import builder.enums.Souce;
import builder.enums.Topping;
import sort.GenerateEmployee;

/**
 * Claque que contiene consumidores que se utilizarán en el proyecto.
 */
public class Consumers
{
	private static Map<Empleado, Pizza> map = new HashMap<>();
	static
	{
		map.put(new Empleado(34, "Javier", GenerateEmployee.crearSalario()), new PizzaBuilder().withBread(BreadType.FLAT_BREAD).withTopping(Topping.HAM)
		.withTopping(Topping.MOZZARELLA_CHEESE).withTopping(Topping.ONIONS).buildPizza());
		
		map.put(new Empleado(43, "María", GenerateEmployee.crearSalario()), new PizzaBuilder().withSouce(Souce.CREAM).withTopping(Topping.PEPPERONI).buildPizza());
		
		map.put(new Empleado(19, "René", GenerateEmployee.crearSalario()), new PizzaBuilder().withBread(BreadType.FLAT_BREAD).withTopping(Topping.PARMESAN_CHEESE)
				.withTopping(Topping.PESTO).buildPizza());
	}
	
	/**
	 * Ejemplo de consumidor.
	 * @param empleados Lista de empleados.
	 */
	public static void consumidor(List<Empleado> empleados)
	{
		empleados.stream().forEach((empleado) -> System.out.println(empleado));
	}
	
	/**
	 * Ejemplo de biconsumidor.
	 */
	public static void biConsumidor()
	{
		map.forEach((empleado, pizza) -> System.out.println("El empleado " + empleado.getNombre() + " pidió una pizza: " + pizza));
	}
}
