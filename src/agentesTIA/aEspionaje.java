package agentesTIA;

import java.util.Arrays;

public final class aEspionaje extends Agente{

	private String [] pisos;

	public aEspionaje(String nombre, int edad, String direccion, float salario, String[] pisos) {
		super(nombre, edad, direccion, salario);
		this.pisos = pisos;
	}

	public String[] getPisos() {
		return pisos;
	}

	public void setPisos(String[] pisos) {
		this.pisos = pisos;
	}

	@Override
	public String toString() {
		return "aEspionaje [pisos=" + Arrays.toString(pisos) + "]";
	}


	
	
	
	
	
}
