package agentesTIA;

import java.io.Serializable;

	/**
	 * @author Tomás Generelo
	 * @author Silvia Montañés
	 * @date 2021-03-01
	 * @version 1.0
	 */

public abstract class Agente implements Serializable{
	
	protected String nombre;
	protected int edad;
	protected String direccion;
	protected float salario;

	/**
	 * Instancia un objeto de clase Agente con los datos especificados.
	 * @param nombre El nombre propio del agente.
	 * @param edad La edad del agente.
	 * @param direccion La dirección postal del agente.
	 * @param salario El salario que cobra el agente.
	 */
	public Agente(String nombre, int edad, String direccion, float salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.salario = salario;
	}
	

//	GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "  Nombre del agente: ".toUpperCase() + nombre + "\n  Edad: ".toUpperCase() + edad + "\n  Dirección: ".toUpperCase() + direccion + "\n  Salario: ".toUpperCase()
				+ salario + " €";
	}

}
