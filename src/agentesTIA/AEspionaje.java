package agentesTIA;

import java.util.Arrays;

import IODatos.IODatos;

public final class AEspionaje extends Agente {

	private String[] vPisos;

	public AEspionaje(String nombre, int edad, String direccion, float salario) {
		super(nombre, edad, direccion, salario);
		this.vPisos = IODatos.cargarDatosTexto("Pisos.txt");
	}

	public String[] getPisos() {
		return vPisos;
	}

	public void setPisos(String[] pisos) {
		this.vPisos = pisos;
	}

	private String todosPisos() {
		String todosPisos = "";

		for (int i = 0; i < vPisos.length; i++) {
			if (vPisos[i] != null) {
				todosPisos += vPisos[i];
			}
			if (i < vPisos.length-1 && vPisos[i+1]!=null)
				todosPisos += ", ";
		}
		
		return todosPisos;

	}

	@Override
	public String toString() {
		return super.toString() + "\nPisos: " + todosPisos();
	}

}
