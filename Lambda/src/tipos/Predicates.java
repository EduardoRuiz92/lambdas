package tipos;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiPredicate;

import beans.Empleado;

/**
 * Claque que contiene predicados que se utilizarán en el proyecto.
 */
public class Predicates
{
	private static BigDecimal	SALARIO_MINIMO = new BigDecimal("100.00");
	private static Integer		EDAD_MINIMA	 = 20;
	
	/**
	 * Ejemplo de predicado.
	 * @param empleados Lista de empleados.
	 * @return true o false
	 */
	public static boolean predicado(List<Empleado> empleados)
	{
		return empleados.stream().anyMatch((empleado) -> empleado.getSalario().compareTo(SALARIO_MINIMO) >= 0);
	}
	
	/**
	 * Ejemplo de bipredicado.
	 * @param empleados Lista de empleados.
	 */
	public static void biPredicado(List<Empleado> empleados)
	{
		BiPredicate<Integer, BigDecimal> biPredicado = (edad, salario) -> edad.compareTo(EDAD_MINIMA) >= 0 && salario.compareTo(SALARIO_MINIMO) >= 0;
		
		empleados.stream().forEach(
			(empleado) -> 
			{
				if(biPredicado.test(empleado.getEdad(), empleado.getSalario()))
					System.out.println("El empleado " + empleado.getNombre() + " gana más del mínimo: " + empleado.getSalario()
							+ " y tiene al menos " + EDAD_MINIMA + ", es decir, tiene " + empleado.getEdad());
			});
	}
}
