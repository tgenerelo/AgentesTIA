package agentesTIA;

import java.util.ArrayList;
import java.util.Iterator;
import IODatos.IODatos;

	/**
	 * @author Tomás Generelo
	 * @author Silvia Montañés
	 * @date 2021-03-01
	 * @version 1.0
	 */

public final class AEspionaje extends Agente {

	private ArrayList<String> vPisos = new ArrayList<String>();
	
	/**
	 * Instancia un objeto de clase AEspionaje con los datos especificados. vPisos se rellena automáticamente con la información del fichero correspondiente.
	 * @param nombre El nombre propio del agente.
	 * @param edad La edad del agente.
	 * @param direccion La dirección postal del agente.
	 * @param salario El salario que cobra el agente.
	 */
	
	public AEspionaje(String nombre, int edad, String direccion, float salario) {
		super(nombre, edad, direccion, salario);
		this.vPisos = IODatos.cargarDatosTexto("recursos/Pisos.txt");
	}

	/**
	 * Genera un String con la lista de pisos de los que dispone el agente, separados por comas.
	 * @return String con todos los pisos separados por comas.
	 */
	private String todosPisos() {
		String todosPisos = "";
	
		Iterator<String> it = vPisos.iterator();
		
		for (String piso : vPisos) {
			todosPisos += piso;
			if (it.hasNext())
				todosPisos += ", ";
		}
		

					
//		while (it.hasNext()) {
//			todosPisos += ", ";				
//		}
	
		return todosPisos;
	}

	
//	GETTERS Y SETTERS

	public ArrayList<String> getvPisos() {
		return vPisos;
	}

	public void setvPisos(ArrayList<String> vPisos) {
		this.vPisos = vPisos;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n  Pisos: ".toUpperCase() + todosPisos();
	}

}
