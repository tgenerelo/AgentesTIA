package agentesTIA;

import IODatos.IODatos;

public final class AEspionaje extends Agente {

	private String[] vPisos;
	
	/**
	 * Instancia un objeto de clase AEspionaje con los datos especificados. vPisos se rellena automáticamente con la información del fichero correspondiente.
	 * @param nombre El nombre propio del agente.
	 * @param edad La edad del agente.
	 * @param direccion La dirección postal del agente.
	 * @param salario El salario que cobra el agente.
	 */
	public AEspionaje(String nombre, int edad, String direccion, float salario) {
		super(nombre, edad, direccion, salario);
		this.vPisos = IODatos.cargarDatosTexto("Pisos.txt");
	}

	/**
	 * Genera un String con la lista de pisos de los que dispone el agente, separados por comas.
	 * @return String con todos los pisos separados por comas.
	 */
	private String todosPisos() {
		String todosPisos = "";
	
		for (int i = 0; i < vPisos.length; i++) {
			if (vPisos[i] != null) {
				todosPisos += vPisos[i];
			}
			if (i < vPisos.length - 1 && vPisos[i + 1] != null)
				todosPisos += ", ";
		}
	
		return todosPisos;
	}

	
//	GETTERS Y SETTERS
	public String[] getPisos() {
		return vPisos;
	}

	public void setPisos(String[] pisos) {
		this.vPisos = pisos;
	}

	@Override
	public String toString() {
		return super.toString() + "\n  Pisos: " + todosPisos();
	}

}
