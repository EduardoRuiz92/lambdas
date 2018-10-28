package beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Bean "Empleado", que implementa a las interfaces Serializable y Comparable.
 */
public class Empleado implements Comparable<Empleado>, Serializable
{
	private Integer edad;
	
	private String nombre;
	
	private BigDecimal salario;

	/**
	 * Constructor por defecto.
	 */
	public Empleado()
	{
		super();
	}

	/**
	 * Constructor con argumentos.
	 * @param edad Edad del empleado.
	 * @param nombre Nombre del empleado.
	 * @param salario Salario del empleado.
	 */
	public Empleado(Integer edad, String nombre, BigDecimal salario)
	{
		super();
		this.edad = edad;
		this.nombre = nombre;
		this.salario = salario;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	/**
	 * Re-implementación del método toString.
	 */
	@Override
	public String toString() {
		return "Empleado [edad=" + edad + ", nombre=" + nombre + ", salario=" + salario + "]";
	}

	/**
	 * Implementación del método compareTo de la interfaz Comparable.
	 * El orden natural de este bean está dado por el salario de los empleados.
	 */
	@Override
	public int compareTo(Empleado e)
	{
		if(this.getSalario().compareTo(e.getSalario()) < 0)
			return -1;
		else if(this.getSalario().compareTo(e.getSalario()) > 0)
			return 1;
		else
			return 0;
	}

}
