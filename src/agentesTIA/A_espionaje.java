package agentesTIA;

import java.util.Arrays;

public final class A_espionaje extends AgenteCampo{

	private String [] pisos;

	public A_espionaje(String nombre, int edad, String direccion, float salario, String[] vPisos, String[] pisos) {
		super(nombre, edad, direccion, salario, vPisos);
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
		return "A_espionaje [pisos=" + Arrays.toString(pisos) + "]";
	}


	
	
	
	
	
}
