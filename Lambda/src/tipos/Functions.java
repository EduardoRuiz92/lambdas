package tipos;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import beans.Empleado;
import builder.Pizza;

/**
 * Claque que contiene funciones que se utilizarán en el proyecto.
 */
public class Functions
{
	private static BigDecimal AUMENTO_ANUAL = new BigDecimal("1.2");
	
	/**
	 * Ejemplo de función.
	 * @param empleados Lista de empleados.
	 */
	public static void funcion(List<Empleado> empleados)
	{
		Function<BigDecimal, BigDecimal> funcion = salario -> salario.multiply(AUMENTO_ANUAL);

		empleados.stream().forEach((empleado) -> System.out.println(
				"El empleado " + empleado.getNombre() + " gana actualmente " + empleado.getSalario() + ", ahora ganará: " + funcion.apply(empleado.getSalario())));
	}
	
	/**
	 * Ejemplo de bifunción.
	 * @param empleados Lista de empleados.
	 */
	public static void funcion2(List<Empleado> empleados)
	{
		Function<BigDecimal, String> funcion = salario -> "$" + salario;

		empleados.stream().forEach((empleado) -> System.out.println(
				"El empleado " + empleado.getNombre() + " gana actualmente " + funcion.apply(empleado.getSalario())));
	}
	
	public static void biFuncion(Empleado emp, Pizza pizz)
	{
		BiFunction<Empleado, Pizza, String> biFunction = (empleado, pizza) ->
			"El empleado " + empleado.getNombre() + " pidió una pizza: " + pizza;
		
		System.out.println( biFunction.apply(emp, pizz) );
	}
}
