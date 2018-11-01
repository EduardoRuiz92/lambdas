package sort;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import beans.Empleado;

/**
 * Clase que generará una lista de empleados.
 */
public class GenerateEmployee
{
	public static List<String> NOMBRES = Arrays.asList("Victor", "José", "Marco", "Marco", "Daniel", "Oscar", "Karen", "Ana", "Eduardo", "Luis", "Salomé");
	
	/**
	 * Método que generará una lista de empleados.
	 */
	public static List<Empleado> crearEmpleados()
	{
		List<Empleado> lista = new ArrayList<Empleado>();
		
		lista.add(new Empleado(23, "Victor", new BigDecimal("3345.23")));
		lista.add(new Empleado(43, "José", new BigDecimal("5435.56")));
		lista.add(new Empleado(13, "Marco", new BigDecimal("594.00")));
		lista.add(new Empleado(64, "Marco", new BigDecimal("1987.90")));
		lista.add(new Empleado(43, "Daniel", new BigDecimal("2500.00")));
		lista.add(new Empleado(42, "Oscar", new BigDecimal("980.03")));
		lista.add(new Empleado(17, "Karen", new BigDecimal("2340.45")));
		lista.add(new Empleado(34, "Ana", new BigDecimal("1398.34")));
		lista.add(new Empleado(29, "Eduardo", new BigDecimal("890.00")));
		lista.add(new Empleado(15, "Luis", new BigDecimal("2500.03")));
		lista.add(new Empleado(20, "Salomé", new BigDecimal("728.00")));
		
		return lista;
	}
	
	/**
	 * Método que genera un empleado con valores aleatorios.
	 * @return Instancia de Empleado.
	 */
	public static Empleado crearEmpleado()
	{
		return new Empleado(crearEdad(), obtenerNombre(), crearSalario());
	}
	
	/**
	 * Método que devuelve un nombre aleatorio de la lista NOMBRES.
	 * @return Nombre del empleado.
	 */
	public static String obtenerNombre()
	{
		return NOMBRES.get(new Random().nextInt(NOMBRES.size()));
	}
	
	/**
	 * Método que genera una salario aleatorio.
	 * @return Salario del empleado.
	 */
	public static BigDecimal crearSalario()
	{
		return new BigDecimal(BigInteger.valueOf(new Random().nextInt(1000001)), 2);
	}
	
	/**
	 * Método que genera una edad para un empleado de forma aleatoria, con un valor entre 18 y 70.
	 * @return Edad del empleado.
	 */
	public static Integer crearEdad()
	{
		return ThreadLocalRandom.current().nextInt(18, 70 + 1);
	}

}
