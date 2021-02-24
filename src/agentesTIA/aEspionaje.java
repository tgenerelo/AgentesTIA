package agentesTIA;

import java.util.Arrays;

public final class aEspionaje extends Agente{

	private String [] vPisos;

	public aEspionaje(String nombre, int edad, String direccion, float salario, String[] pisos) {
		super(nombre, edad, direccion, salario);
		this.vPisos = pisos;
	}

	public String[] getPisos() {
		return vPisos;
	}

	public void setPisos(String[] pisos) {
		this.vPisos = pisos;
	}

	@Override
	public String toString() {
		return "aEspionaje [pisos=" + Arrays.toString(vPisos) + "]";
	}


	
	
	
	
	
}
