package agentesTIA;

import java.util.Arrays;

import IODatos.IODatos;

public final class AEspionaje extends Agente{

	private String [] vPisos;

	public AEspionaje(String nombre, int edad, String direccion, float salario) {
		super(nombre, edad, direccion, salario);
		this.vPisos = IODatos.cargarDatosTexto("ficheros/pisos.txt");
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
