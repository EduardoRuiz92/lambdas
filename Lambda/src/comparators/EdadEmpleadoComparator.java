package comparators;

import java.util.Comparator;

import beans.Empleado;

/**
 * Comparator empleado para ordenar empleados de acuerdo a su edad.
 */
public class EdadEmpleadoComparator implements Comparator<Empleado>
{
	/**
	 * Implementación del método abstracto compare, en este caso, para ordenar de acuerdo a la edad de los empleados.
	 */
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
}
