package builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import builder.enums.BreadType;
import builder.enums.Souce;
import builder.enums.Topping;

/**
 * Builder del bean Pizza.
 */
public class PizzaBuilder
{
	/**
	 * Valores por defecto.
	 */
	private List<Topping> _toppings = new ArrayList<Topping>();

	private BreadType _breadType = BreadType.PIZZA_PAN;

	private Souce _souce = Souce.TOMATO;

	/**
	 * Método del builder para agregar un nuevo ingrediente a la pizza.
	 * @param topping Ingrediente para agregar.
	 * @return Se devuelve este mismo builder.
	 */
	public PizzaBuilder withTopping(Topping topping)
	{
		_toppings.add(topping);
		return this;
	}

	/**
	 * Método del builder para cambiar el tipo de pan de la pizza. 
	 * @param breadType Tipo de pan para la pizza.
	 * @return Se devuelve este mismo builder.
	 */
	public PizzaBuilder withBread(BreadType breadType)
	{
		_breadType = breadType;
		return this;
	}

	/**
	 * Método del builder para cambiar la salsa de la pizza.
	 * @param souce Salsa de la pizza.
	 * @return Se devuelve este mismo builder.
	 */
	public PizzaBuilder withSouce(Souce souce)
	{
		_souce = souce;
		return this;
	}
	
	/**
	 * Método que elimina el primer Topping de la lista, si hay almenos uno.
	 * @return Se devuelve este mismo builder.
	 */
	public PizzaBuilder removeFirstTopping()
	{
		if(_toppings.size() > 0)
			_toppings.remove(0);
		return this;
	}
	
	/**
	 * Método que elimina el último Topping de la lista, si hay almenos uno.
	 * @return Se devuelve este mismo builder.
	 */
	public PizzaBuilder removeLastTopping()
	{
		if(_toppings.size() > 0)
			_toppings.remove(_toppings.size() - 1);
		return this;
	}
	
	/**
	 * Método que elimina el primer Topping de la lista que coincida con el proporcionado.
	 * @param topping
	 * @return Se devuelve este mismo builder.
	 */
	public PizzaBuilder removeTopping(Topping topping)
	{
		_toppings.remove(topping);
		return this;
	}
	
	/**
	 * Método que elimina todos los Toppings de la lista.
	 * @return Se devuelve este mismo builder.
	 */
	public PizzaBuilder removeAllToppings()
	{
		_toppings.clear();
		return this;
	}
	
	/**
	 * Método que elimina todos los Toppings de la lista que coincidan con el proporcionado.
	 * @param topping
	 * @return Se devuelve este mismo builder.
	 */
	public PizzaBuilder removeAllToppings(Topping topping)
	{
		_toppings.removeIf((_topping) -> _topping == topping);
		return this;
	}
	
	/**
	 * Método que, una vez terminado el ensamblaje de la pizza,
	 * devuelve un objeto Pizza con todos los elementos seteados.
	 * @return Devuelve un objeto Pizza.
	 */
	public Pizza buildPizza()
	{
		return new Pizza(_toppings, _breadType, _souce);
	}

}
