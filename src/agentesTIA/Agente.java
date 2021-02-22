package agentesTIA;

public abstract class Agente {
	
	protected String nombre;
	protected int edad;
	protected String direccion;
	protected float salario;
	
	
	public Agente(String nombre, int edad, String direccion, float salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.salario = salario;
	}

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
		return "Agente [nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + ", salario=" + salario
				+ "]";
	}
	
	
	
	
	
	
	
	
	

}
