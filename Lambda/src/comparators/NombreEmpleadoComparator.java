package comparators;

import java.util.Comparator;

import beans.Empleado;

/**
 * Comparator empleado para ordenar empleados de acuerdo a su nombre.
 */
public class NombreEmpleadoComparator implements Comparator<Empleado>
{

	/**
	 * Implementación del método abstracto compare, en este caso, para ordenar de acuerdo al nombre de los empleados.
	 */
	@Override
	public int compare(Empleado e1, Empleado e2)
	{
		return e1.getNombre().compareTo(e2.getNombre());
	}

}
