package tipos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import beans.Empleado;
import sort.GenerateEmployee;

public class Suppliers
{
	private static int CANTIDAD_EMPLEADOS = 15;
	
	public static List<Empleado> proveedor()
	{
		Supplier<Empleado> empleado  = () -> GenerateEmployee.crearEmpleado();
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		for(int cont = 1; cont <= CANTIDAD_EMPLEADOS; cont++)
			empleados.add(empleado.get());
		
		return empleados;
	}
}
