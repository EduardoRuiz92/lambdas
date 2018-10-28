package builder;

import java.util.List;

import builder.enums.BreadType;
import builder.enums.Souce;
import builder.enums.Topping;

/**
 * Bean Pizza, que tiene tres propiedades.
 */
public class Pizza
{
	private final List<Topping> _toppings;

	private final BreadType _breadType;

	private final Souce _souce;

	/**
	 * Constructor con argumentos.
	 * 
	 * @param toppings Lista de ingredientes posibles.
	 * @param breadType Tipo de pan de la pizza.
	 * @param souce Salsa de la pizza.
	 */
	public Pizza(List<Topping> toppings, BreadType breadType, Souce souce)
	{
		super();
		_toppings = toppings;
		_breadType = breadType;
		_souce = souce;
	}

	public final List<Topping> getToppings()
	{
		return _toppings;
	}

	public final BreadType getBreadType()
	{
		return _breadType;
	}

	public final Souce getSouce()
	{
		return _souce;
	}

	@Override
	public String toString()
	{
		return "Pizza [_toppings=" + _toppings + ", _breadType=" + _breadType + ", _souce=" + _souce + "]";
	}
	
}
