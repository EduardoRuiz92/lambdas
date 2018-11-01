package tipos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import beans.Empleado;
import sort.GenerateEmployee;

/**
 * Claque que contiene proveedores que se utilizar�n en el proyecto.
 */
public class Suppliers
{
	private static int CANTIDAD_EMPLEADOS = 15;
	
	/**
	 * M�todo que devuelev una lista de empleados, seg�n la cantidad indicada en la variable de clase.
	 * @return Lista de empleados.
	 */
	public static List<Empleado> proveedor()
	{
		Supplier<Empleado> empleado  = () -> GenerateEmployee.crearEmpleado();
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		for(int cont = 1; cont <= CANTIDAD_EMPLEADOS; cont++)
			empleados.add(empleado.get());
		
		return empleados;
	}
}
