package sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import beans.Empleado;
import builder.PizzaBuilder;
import builder.enums.BreadType;
import builder.enums.Souce;
import builder.enums.Topping;
import comparators.EdadEmpleadoComparator;
import comparators.NombreEmpleadoComparator;
import tipos.Consumers;
import tipos.Functions;
import tipos.Predicates;
import tipos.Suppliers;

/**
 * Clase que se utilizará durante el apartado de lambdas del curso de Java.
 */
public class Sort
{
	private static BigDecimal SALARIO_MINIMO = new BigDecimal("1000");
	
	/**
	 * Método main que ejecutará las diferentes pruebas del proyecto.
	 * 
	 * @param args Arreglo de cadenas.
	 */
	public static void main(String[] args)
	{
		test1();
//		test2();
//		test3();
//		test4();
//		test5();
//		test6();
//		test7();
//		test8();
//		test9();
//		test10();
//		test11();
//		consumers();
//		predicates();
//		functions();
//		suppliers();
//		builder();
//		contarEmpleados();
//		contarEmpleadosStreaming();
//		imprimirEmpleadosFiltrados();
//		imprimirEmpleadosFiltradosStreaming();
//		streaming();
	}

	/**
	 * Ordenando números que se saben comparar.
	 */
	private static void test1()
	{
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(24);
		numeros.add(33);
		numeros.add(85);
		numeros.add(5);
		numeros.add(75);
		numeros.add(27);
		numeros.add(69);
		
		Collections.sort(numeros);
		
		imprimir(numeros);
	}
	
	/**
	 * Ordenando cadenas.
	 */
	private static void test2()
	{
		List<String> nombres = new ArrayList<String>();
		nombres.add("Karen");
		nombres.add("Victor");
		nombres.add("Héctor");
		nombres.add("José");
		nombres.add("Jose");
		nombres.add("Marquito");
		nombres.add("Oscar");
		nombres.add("dany bebe");
		
		Collections.sort(nombres);
		
		imprimir(nombres);
	}
	
	/**
	 * Ordenando empleados a través de su orden natural, por medio de la interfaz Comparable. Se ordena por salario.
	 */
	private static void test3()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
		Collections.sort(empleados);
		imprimir(empleados);
	}
	
	/**
	 * Ordenando empleados a través de una clase que implementa a la interfaz Comparator. Se ordena por edad.
	 */
	private static void test4()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
		Comparator<Empleado> comparator = new EdadEmpleadoComparator();
		Collections.sort(empleados, comparator);
		imprimir(empleados);
	}
	
	/**
	 * Ordenando empleados con una clase que implementa a Comparator, en este caso, se utilizan sus nombres. 
	 */
	private static void test5()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
		Comparator<Empleado> comparator = new NombreEmpleadoComparator();
		Collections.sort(empleados, comparator);
		imprimir(empleados);
	}
	
	/**
	 * Se utiliza una clase anónima para ordenar a los empleados de acuerdo a su edad.
	 * La clase anónima cumple una relación "is a" con la interfaz Comparator. Se ordena por edad.
	 */
	private static void test6()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
		
		Comparator<Empleado> comparator = new Comparator<Empleado>()
		{
			@Override
			public int compare(Empleado e1, Empleado e2)
			{
				if(e1.getEdad() < e2.getEdad())
					return -1;
				else if(e1.getEdad() > e2.getEdad())
					return 1;
				else
					return 0;
			}
		};
		
//		Comparator<Empleado> c2 = comparator.reversed();
		Collections.sort(empleados, comparator);
		imprimir(empleados);
	}
	
	/**
	 * Nuevamente se ocupa una clase anónima para ordenar, en esta ocasión, por edad
	 * y usando el método compareTo() de la clase Integer a la que pertenece la edad de los empleados.
	 */
	private static void test7()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
		Comparator<Empleado> comparator = new Comparator<Empleado>()
		{
			@Override
			public int compare(Empleado e1, Empleado e2)
			{
				return e1.getEdad().compareTo(e2.getEdad());
			}
		};
		Collections.sort(empleados, comparator);
		imprimir(empleados);
	}
	
	/**
	 * Primera lamda, que cumple una relación "is a" con Comparator,
	 * básicamente es lo mismo que se hace en el método anterior.
	 */
	private static void test8()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
		
		Comparator<Empleado> comparator = (e1, e2) -> e1.getEdad().compareTo(e2.getEdad());
		
		Collections.sort(empleados, comparator);
		imprimir(empleados);
	}
	
	/**
	 * Segunda lambda, ordena de acuerdo al nombre de los empleados.
	 */
	private static void test9()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
		Comparator<Empleado> comparator = (e1, e2) -> e1.getNombre().compareTo(e2.getNombre());
		Collections.sort(empleados, comparator);
		imprimir(empleados);		
	}
	
	/**
	 * Tercera lambda, que ordena de acuerdo al salario de los empleados.
	 */
	private static void test10()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
		Comparator<Empleado> comparator = (e1, e2) -> e1.getSalario().compareTo(e2.getSalario());
		Collections.sort(empleados, comparator);
		imprimir(empleados);
	}
	
	/**
	 * Primer uso de la API de streaming, se puede apreciar el uso del patrón de diseño Builder.
	 */
	private static void test11()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
		Long cantidad = empleados.stream().filter((empleado) -> empleado.getSalario().compareTo(SALARIO_MINIMO) > 0  )
		.count();
		System.out.println("Hay " + cantidad + " empleados que ganan más de $1000");
	}
	
	/**
	 * Utilizamos dos tipos de lambdas, Consumidores y BiConsumidores.
	 */
	private static void consumers()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
//		Consumers.consumidor(empleados);
		Consumers.biConsumidor();
	}
	
	/**
	 * Utilizamos dos tipos de lambdas, Predicados y BiPredicados.
	 */
	private static void predicates()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
//		if(Predicates.predicado(empleados))
//			System.out.println("Sí hay empleados con más de $10,000.00");
		Predicates.biPredicado(empleados);
	}
	
	/**
	 * Utilizamos dos tipos de lambdas, Funciones y BiFunciones.
	 */
	private static void functions()
	{
		List<Empleado> empleados = GenerateEmployee.crearEmpleados();
//		Functions.funcion(empleados);
//		Functions.funcion2(empleados);
		Functions.biFuncion(empleados.get(0), new PizzaBuilder().withBread(BreadType.FLAT_BREAD).withSouce(Souce.TOMATO).withTopping(Topping.HAM)
				.withTopping(Topping.MOZZARELLA_CHEESE).withTopping(Topping.ONIONS).buildPizza());
	}
	
	/**
	 * Utilizamos el tipo de lambdas, Proveedores.
	 */
	private static void suppliers()
	{
		Suppliers.proveedor().stream().forEach((empleado) -> System.out.println(empleado));
	}
	
	/**
	 * Método que indica cuántos empleados hay con un salario igual o mayor a $5,000.00.
	 */
	private static void contarEmpleados()
	{
		long cantidad = 0;
		List<Empleado> empleados = Suppliers.proveedor();
		
		for(Empleado empleado : empleados)
			if(empleado.getSalario().compareTo(new BigDecimal(5_000)) >= 0)
				cantidad++;
		
		System.out.print("La lista tiene " + cantidad + " empleados que ganan más de $5,000.00");
	}
	
	/**
	 * Método que indica cuántos empleados hay con un salario igual o mayor a $5,000.00,
	 * utilizando lambdas y el API stream.
	 */
	private static void contarEmpleadosStreaming()
	{
		long cantidad = 0;
		List<Empleado> empleados = Suppliers.proveedor();
		
		cantidad = empleados.stream().filter((empleado) -> 
					empleado.getSalario().compareTo(new BigDecimal(5_000)) >= 0).count();
		
		System.out.print("La lista tiene " + cantidad + " empleados que ganan más de $5,000.00");
	}
	
	/**
	 * Método que imprime a los empleados con un salario igual o mayor a $5,000.00.
	 */
	private static void imprimirEmpleadosFiltrados()
	{
		List<Empleado> empleados = Suppliers.proveedor();
		List<Empleado> filtrados = new ArrayList<>();
		
		for(Empleado empleado : empleados)
			if(empleado.getSalario().compareTo(new BigDecimal(5_000)) >= 0)
				filtrados.add(empleado);
		
		for(Empleado empleado : filtrados)
			System.out.println(empleado);
	}
	
	/**
	 * Método que imprime a los empleados con un salario igual o mayor a $5,000.00,
	 * utilizando lambdas y el API stream.
	 */
	private static void imprimirEmpleadosFiltradosStreaming()
	{	
		Suppliers.proveedor().stream().filter((empleado) -> 
			empleado.getSalario().compareTo(new BigDecimal(5000)) >= 0)
				.forEach((empleado) -> System.out.println(empleado));
	}
	
	/**
	 * Método que imprime una lista de obetos, a través de su método "toString".
	 * 
	 * @param objetos Lista de los objetos a imprimir.
	 */
	private static void imprimir(List objetos)
	{
		for(Object obj : objetos)
		{
			System.out.println(obj);
		}
	}
	
}
